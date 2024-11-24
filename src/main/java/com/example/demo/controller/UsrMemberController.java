package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Dto.Member;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UsrMemberController {

	private MemberService memberService;

	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/usr/member/join")
	public String join() {
		return "usr/member/join";
	}

	@PostMapping("/usr/member/doJoin")
	public String doJoin(String eMail, String loginPw, String name) {
		memberService.joinMember(eMail, loginPw, name);
		return "redirect:/usr/home/success";
	}

	@GetMapping("/usr/member/login")
	public String login(HttpServletRequest req) {
		Member loginedMember = (Member) req.getSession().getAttribute("loginedMember");

		if (loginedMember != null) {
			// 이미 로그인된 상태이면 실패 페이지로 리디렉션
			return "redirect:/usr/home/fail";
		}
		
		return "usr/member/login";
	}

	@PostMapping("/usr/member/doLogin")
	public String doLogin(HttpServletRequest req, String eMail, String loginPw) {

		

		Member member = memberService.getLoginId(eMail);

		if (member == null) {
			return "redirect:/usr/home/fail";
		}

		if (!member.getLoginPw().equals(loginPw)) {
			return "redirect:/usr/home/fail";
		}

		req.getSession().setAttribute("loginedMember", member);

		return "redirect:/usr/home/success";
	}

	@GetMapping("/usr/member/myPage")
	public String myPage(HttpServletRequest req, Model model) {
		Member member = (Member) req.getSession().getAttribute("loginedMember");

		if (member == null) {
			return "redirect:/usr/member/login";
		}

		model.addAttribute("member", member);
		return "usr/member/myPage";
	}
	
	@GetMapping("/usr/member/modify")
	public String memberModify() {
		return "usr/member/modify";
	}
	
	@PostMapping("/usr/member/doModify")
	public String postMethodName(HttpServletRequest req, String loginPw) {
		Member member = (Member) req.getSession().getAttribute("loginedMember");
		
		memberService.modifyPw(member.getId(), loginPw);
		
		return "redirect:/usr/member/myPage";
	}
	

}
