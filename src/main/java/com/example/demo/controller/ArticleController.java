package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Article;
import com.example.demo.dto.Member;
import com.example.demo.dto.Reply;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ReplyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ArticleController {
	private ArticleService articleService;
	private ReplyService replyService;
	private HttpSession session;
	
	public ArticleController(ArticleService articleService, ReplyService replyService, HttpSession session) {
		this.articleService = articleService;
		this.replyService = replyService;
		this.session = session;
	}
	
	@GetMapping("/usr/home/articleHome")
	public String articleHome() {
		
		return "/usr/home/articleHome";
	}
	
	
	@GetMapping("/usr/article/write")
	public String write(Model model) {
		
		Member loginedMember = (Member) session.getAttribute("loginedMember");

		if (loginedMember == null) {
			model.addAttribute("message", "로그인 먼저 해주세요.");
			return "/usr/home/fail";
		}
		return "/usr/article/write";
	}
	
	@PostMapping("/usr/article/doWrite")
	public String doWrite(Model model, String title, String body) {
		Member loginedMember = (Member) session.getAttribute("loginedMember");

		if (loginedMember == null) {
			model.addAttribute("message", "로그인 먼저 해주세요.");
			return "/usr/home/fail";
		}
		
		articleService.writeArticle(loginedMember.getId(), title, body);
		return "redirect:/usr/article/list";
	}
	
	@GetMapping("/usr/article/list")
	public String list(Model model) {
		
		List<Article> articles = articleService.getArticles();
		
		model.addAttribute("articles", articles);
		return "usr/article/list";
	}
	
	
	@GetMapping("/usr/article/detail")
	public String detail(Model model, int id) {
		
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			model.addAttribute("message", "게시물이 없습니다.");
			return "/usr/home/fail";
		}
		
		List<Reply> replies = replyService.getReplies(article.getId());
		
		model.addAttribute("article", article);
		model.addAttribute("replies", replies);
		
		return "/usr/article/detail";
	}
	
	
	
}
