package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@Autowired
	private HelloService service;
	
	// URLパスが/helloのGETリクエストに対して、hello.htmlを返す。
	@GetMapping("/hello")
	public String getHello() {
		// 戻り値には、拡張子を除いたHTMLファイル。[src.main/resources/templates/]からの相対パス。
		return "hello"; 
	}
	
	/**
	 * URLパスが/helloのPOSTリクエストに対して、画面で入力された値を受け取り、hello/response.htmlを返す。
	 * @param str @RequestParam("text1")：HTMLのname属性と一致させる。画面で入力された値を受け取る方法の一つ。
	 * @param model Model：HTMLに値を渡すためのオブジェクト。Spring MVCの機能。
	 * @return
	 */
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {
		// key="sample"で値をHTMLに渡す。
		model.addAttribute("sample", str);
		
		return "hello/response";
	}
	
	// hello/db.htmlでのPOSTリクエスト処理
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2") String id, Model model) {
		Employee employee = service.getEmployee(id);
		
		model.addAttribute("employee", employee);
		
		// db.htmlに画面遷移
		return "hello/db";
	}
}