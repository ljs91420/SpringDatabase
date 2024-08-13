package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CookieTestController {
	@GetMapping("/cookie/test1")
	public String test1(HttpServletResponse response) {
		response.addCookie(new Cookie("uid", "1234"));
		response.addCookie(new Cookie("fid", "ABCD"));
		response.addCookie(new Cookie("cid", "FDFD123"));
		
		Cookie pidCookie = new Cookie("pid", "4321");
		
		pidCookie.setMaxAge(300);
		pidCookie.setHttpOnly(true); // 자바스크립트 쪽에서 사용하지 못하는 쿠키
		
		response.addCookie(pidCookie);
		
		return "/cookie/index";
	}
	
	@GetMapping("/cookie/test2")
	public String test2(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		log.info("#### 모든 쿠키 출력하기 ####");
		for (Cookie cookie : cookies) {
			log.info("{}={}", cookie.getName(), cookie.getValue());
		}
		
		return "/cookie/index";
	}
	
	@GetMapping("/cookie/test3")
	public String test3(@CookieValue(name = "uid", required = true) Cookie uidCookie) {
		log.info("test3에서 받은 쿠키 : {}={}", uidCookie.getName(), uidCookie.getValue());
		return "/cookie/index";
	}
}
