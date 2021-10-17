package com.example.kolook.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kolook.customer.domain.model.Customer;


@Controller
public class AuthController {
	@GetMapping("/login")
	public String getAdminLogin(Model model) {
		System.out.println("Get:/login");
		//htmlテンプレートのコンテンツ部分にログイン画面を表示するための文字列を登録
		model.addAttribute("loginForm", new Customer());
		//contents内に格納
		model.addAttribute("contents", "login::login_contents");

		return "layout";
	}
	// ログイン画面のGET用コントローラー
	// login/login.htmlに遷移

	@PostMapping("/login")
	public String postAdminLogin(Model model) {
		System.out.println("Post:/login");
		model.addAttribute("contents", "login::login_contents");

		return "layout";
	}
	//ログイン画面のPOST用コントローラー
	//login/top.htmlに遷移
	@RequestMapping("/")
	public String index() {
		return "redirect:/top";
	}

}