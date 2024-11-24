package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Dto.Article;
import com.example.demo.Dto.Member;
import com.example.demo.service.ArticleService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsrArticleController {

	private ArticleService articleService;
	
	public UsrArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping("/usr/article/write")
	public String write(HttpServletRequest req) {
		Member loginedMember = (Member) req.getSession().getAttribute("loginedMember");
		
		if(loginedMember == null) {
			return "redirect:/usr/member/login";
		}
		return "usr/article/write";
	}
	
	@PostMapping("/usr/article/doWrite")
	public String doWrite(HttpServletRequest req, String title, String body) {
		Member loginedMember = (Member) req.getSession().getAttribute("loginedMember");
		
		if(loginedMember == null) {
			return "redirect:/usr/member/login";
		}
		
		articleService.writeArticle(loginedMember.getId(), title, body);
		return "redirect:/usr/home/success";
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
		
		model.addAttribute("article", article);
		return "usr/article/detail";
	}
	
	
	
}
