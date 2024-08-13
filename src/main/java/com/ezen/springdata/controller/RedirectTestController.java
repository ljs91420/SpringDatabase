package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RedirectTestController {
	@GetMapping(value = {"/redirect/", "/redirect/home"})
	public String home(String fruit, Integer price, Model model) {
		// 어트리뷰트의 이름을 생략하고 추가하는 경우 해당 클래스의 이름으로 이름을 자동 생성한다.(e.g Employee -> employee)
		// 생략하고 추가할 때는 절대로 null을 추가할 수 없다.(null로는 이름 자동 생성이 불가능)
		model.addAttribute(fruit);
		model.addAttribute(price);
//		model.addAttribute("fruit", fruit);
//		model.addAttribute("price", price);
		return "/redirect/home";
	}
	
	@GetMapping("/redirect")
	public String home2() {
		log.info("홈2에 도착했다 홈으로 갑니다.");
		return "redirect:/redirect/";
	}
	
	@GetMapping("/redirect/test1")
	public String test1() {
		log.info("테스트1에 도착했다 홈으로 갑니다.");
		return "redirect:/redirect/";
	}
	
	@GetMapping("/redirect/test2")
	public String test2() {
		log.info("리다이렉트시에 GET방식으로 파라미터 전달하기");
		return "redirect:/redirect/home?fruit=apple&price=2000";
	}
	
	@GetMapping("/redirect/home3")
	public String home3() {
		return "/redirect/home";
	}
	
	@GetMapping("/redirect/test3")
	public String test3(RedirectAttributes rattr) {
		// 리다이렉트시에 한 번 사용되고 사라지는 어트리뷰트(메모리 관리 용이)
		rattr.addFlashAttribute("fruit", "grape");
		rattr.addFlashAttribute("price", "3500");
		return "redirect:/redirect/";
	}
}
