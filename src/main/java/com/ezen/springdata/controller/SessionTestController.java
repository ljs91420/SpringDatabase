package com.ezen.springdata.controller;

import java.util.Enumeration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@SessionAttributes(names = {"point", "isVip"})
@Slf4j
@Controller
public class SessionTestController {
	@GetMapping("/session/test1")
	public String test1(HttpServletRequest request, HttpSession session) {
		log.info("1번 방식으로 꺼낸 세션 : {}", request.getSession());
		log.info("2번 방식으로 꺼낸 세션 : {}", session);
		
		session.setAttribute("nickname", "아이스아메리카노");
		
		return "/session/index";
	}
	
	@GetMapping("/session/test2")
	public String test2(@SessionAttribute("nickname") String nickname, @SessionAttribute(name = "point", required = false) Integer point) {
		log.info("@SessionAttribute로 꺼낸 nickname : {}", nickname);
		log.info("@SessionAttribute로 꺼낸 point : {}", point);
		return "/session/index";
	}
	
	@GetMapping("/session/test3")
	public String test3(HttpSession session) {
		// scope.getAttributeNames() : 모든 어트리뷰트의 이름을 하나씩 꺼낼 수 있는 객체를 반환
		log.info("#### 세션이 보유한 모든 어트리뷰트들 ####");
		Enumeration<String> attrNames = session.getAttributeNames();
		
		// Enumeration 객체의 사용법은 ResultSet과 비슷하다.
		while (attrNames.hasMoreElements()) {
			String attrName = attrNames.nextElement();
			
			log.info("{}={}", attrName, session.getAttribute(attrName));
		}
		
		return "/session/index";
	}
	
	@GetMapping("/session/test4")
	public String test4(Model model) {
		// @SessionAttributes에 등록된 이름들은 세션 영역에 추가된다.
		model.addAttribute("point", 1835);
		model.addAttribute("isVip", true);
		
		int price = 3500;
		int qty = 3;
		
		// @SessionAttributes에 등록된 이름이 아니기 때문에 리퀘스트 영역에 추가된다.
		model.addAttribute("price", price);
		model.addAttribute("qty", qty);
		model.addAttribute("totalPrice", price * qty);
		
		return "/session/index";
	}
}
