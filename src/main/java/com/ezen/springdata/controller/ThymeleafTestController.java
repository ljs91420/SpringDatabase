package com.ezen.springdata.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdata.dto.FruitDTO;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafTestController {
	@GetMapping("/form")
	public String form(Model model) {
		FruitDTO fruit = new FruitDTO();
		fruit.setFid(10);
		fruit.setFname("수박");
		fruit.setPrice(300);
		fruit.setQty(20);
		fruit.setExp_date(new Date());
		model.addAttribute("fruit", fruit);
		model.addAttribute("fruit2", new FruitDTO());
		model.addAttribute("animals", new String[] {"호랑이", "사자", "기린", "팬더"});
		model.addAttribute("age", 25);
		return "th/form";
	}
}
