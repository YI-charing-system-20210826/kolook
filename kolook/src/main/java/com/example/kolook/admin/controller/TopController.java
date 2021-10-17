package com.example.kolook.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TopController {
	@GetMapping("/top")
	public String getTop(Model model) {

		model.addAttribute("contents", "top::top_contents");

		return "layout";
	}



	@PostMapping("/top")
	public String postTop(Model model) {
		model.addAttribute("contents", "top::top_contents");

		return "layout";
	}
}
