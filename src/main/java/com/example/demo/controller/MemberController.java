package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	private MemberService memberService;
	private HttpSession session;

	public MemberController(MemberService memberService, HttpSession session) {
		this.memberService = memberService;
		this.session = session;
	}

	@GetMapping("/usr/member/join")
	public String join(Model model) {
		Member loginedMember = (Member) session.getAttribute("loginedMember");

		if (loginedMember != null) {
			model.addAttribute("message", "로그인이 이미 되어있습니다.");
			return "/usr/home/fail";
		}
		return "/usr/member/join";
	}

	@PostMapping("/usr/member/doJoin")
	public String doJoin(Model model, String email, String loginPw, String name) {

		Member member = memberService.getMemberId(email);

		if (member != null) {
			model.addAttribute("message", "이미 있는 이메일입니다.");
			return "/usr/home/fail";
		}

		memberService.joinMember(email, loginPw, name);

		model.addAttribute("message", "회원가입 성공!");
		return "/usr/home/success";
	}

	@GetMapping("/usr/member/login")
	public String login(Model model) {
		Member loginedMember = (Member) session.getAttribute("loginedMember");

		if (loginedMember != null) {
			model.addAttribute("message", "로그인이 이미 되어있습니다.");
			return "/usr/home/fail";
		}

		return "/usr/member/login";
	}

	@PostMapping("/usr/member/doLogin")
	public String doLogin(Model model, String email, String loginPw) {

		Member member = memberService.getMemberId(email);

		if (member == null) {
			model.addAttribute("message", "없는 아이디 입니다.");
			return "/usr/home/fail";
		}

		if (!member.getLoginPw().equals(loginPw)) {
			model.addAttribute("message", "비밀번호를 확인해주세요.");
			return "/usr/home/fail";
		}

		session.setAttribute("loginedMember", member);
		
		model.addAttribute("message", "로그인 성공!");
		return "/usr/home/success";
	}

	@GetMapping("/usr/member/logout")
	public String logout(Model model) {

		Member loginedMember = (Member) session.getAttribute("loginedMember");

		if (loginedMember == null) {
			model.addAttribute("message", "로그인이 안 되어있습니다.");
			return "/usr/home/fail";
		}

		session.invalidate();
		
		model.addAttribute("message", "로그아웃 성공!");
		return "/usr/home/success";
	}

	@GetMapping("/usr/member/myPage")
	public String myPage(Model model) {
		Member member = (Member) session.getAttribute("loginedMember");

		if (member == null) {
			model.addAttribute("message", "로그인 먼저 해주세요.");
			return "/usr/home/fail";
		}

		model.addAttribute("member", member);
		return "usr/member/myPage";
	}

	@GetMapping("/usr/member/modify")
	public String memberModify() {
		return "usr/member/modify";
	}

	@PostMapping("/usr/member/doModify")
	public String postMethodName(Model model, String loginPw) {
		Member member = (Member) session.getAttribute("loginedMember");

		memberService.modifyPw(member.getId(), loginPw);
		
		model.addAttribute("message", "비밀번호 변경 성공!");
		return "/usr/home/success";
	}

}
