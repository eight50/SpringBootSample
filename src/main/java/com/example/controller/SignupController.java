package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;

@Controller
@RequestMapping("/user") // URLのプリフィックス(接頭辞)になる。例：localhost:8080/user/になる
public class SignupController {
	@Autowired
	private UserApplicationService userApplicationService;

	/**
	 * ユーザ登録画面を表示
	 * @param model
	 * @return ユーザ登録画面のテンプレート名（.html）
	 */
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale) {
		// 性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		
		return "user/signup";
	}
	
	/**
	 * ユーザ登録処理
	 */
	@PostMapping("/singup")
	public String postSignup() {
		// ログイン画面にリダイレクト
		// ユーザ登録した後、他の画面をGet（POST-Redirect-GET:PRG）して、誤った操作や、画面更新による二重登録を防止
		return "redirect:/login";
	}
}
