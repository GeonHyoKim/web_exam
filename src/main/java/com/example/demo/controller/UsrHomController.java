package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsrHomController {
	
	
	@GetMapping("/usr/home/main")
	public String showhome() {
		return "/usr/home/main";
	}
	
	@GetMapping("/")
	public String showroot() {
		return "redirect:/usr/home/main";
	}
	
}
