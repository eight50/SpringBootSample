package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user") // URLのプリフィックス(接頭辞)になる。例：localhost:8080/user/になる
@Slf4j // @Slf4jはLombokのアノテーションで、ログ出力
public class SignupController {
	@Autowired
	private UserApplicationService userApplicationService;

	/**
	 * ユーザ登録画面を表示
	 * @param model
	 * @param locale
	 * @param form @ModelAttribute: model.Attribute("signupForm", form)と同じ意味
	 * @return ユーザ登録画面のテンプレート名（.html）
	 */
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		// 性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		
		return "user/signup";
	}
	
	/**
	 * ユーザ登録処理
	 */
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, @ModelAttribute SignupForm form, BindingResult bindingResult) {
		// 入力チェック
		if(bindingResult.hasErrors()) {
			// True -> エラー有り、ユーザー登録画面に戻る
			return getSignup(model, locale, form);
		}
		
		log.info(form.toString());
		// ログイン画面にリダイレクト
		// ユーザ登録した後、他の画面をGet（POST-Redirect-GET:PRG）して、誤った操作や、画面更新による二重登録を防止
		return "redirect:/login";
	}
}
