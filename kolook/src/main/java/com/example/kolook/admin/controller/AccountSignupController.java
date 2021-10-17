package com.example.kolook.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountSignupController {

	//　管理者登録画面のGet用コントローラー
	@GetMapping("/adminSingup")
	public String getSignup1() {
		//	login/signup.htmlに遷移
		return "signup.html";
	}

	//	管理者画面のPOST用コントローラー
	@PostMapping("/adminSignup")
	public String PostSignup() {
		//	登録完了後、login/login.htmlにリダイレクト
		return "login.html";
	}

	//	管理者登録処理
	//	管理者登録結果の判定
}
