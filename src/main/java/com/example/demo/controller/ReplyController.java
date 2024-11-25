package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.ReplyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReplyController {

    private ReplyService replyService;
    private HttpSession session;

    public ReplyController(ReplyService replyService, HttpSession session) {
        this.replyService = replyService;
        this.session = session;
    }


    @PostMapping("/usr/reply/doWrite")
    public String doWrite(Model model, int relId, String body) {
        Member loginedMember = (Member) session.getAttribute("loginedMember");

        if (loginedMember == null) {
        	model.addAttribute("message", "로그인 먼저 해주세요.");
            return "/usr/home/fail"; 
        }

        replyService.writeReply(loginedMember.getId(), relId, body);

        return "redirect:/usr/article/list";
    }
}
