package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	@GetMapping("/hi")
	public String hi() {
		return "greetings"; // greetings.mustache
	}
	
	@GetMapping("/hi2")
	public String hi2(Model model) {
		model.addAttribute("username","로제파스타");
		return "greetings2"; // greetings.mustache
	}
	
	@GetMapping("/hi3")
	public String hi3(Model model) {
		model.addAttribute("username","금춘봉");
		return "greetings3"; // greetings.mustache
	}
	
	@GetMapping("/hi4")
	public String hi4(Model model) {
		model.addAttribute("username","로제파스타");
		return "greetings4"; // greetings.mustache
	}
}
