package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdata.dto.FruitDTO;
import com.ezen.springdata.mapper.FruitRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/fruits")
@RequiredArgsConstructor
@Controller
public class FruitsTestController {
	
	private final FruitRepository fruitRepository;
	
	
	@GetMapping("/add")
	public String addFruitForm() {
		return "fruit/add_form";
	}
	@PostMapping("/add")
	public String addFruit(FruitDTO fruitDto) {
		log.info("{}", fruitDto);
		
		log.info("INSERT 결과 : {}", fruitRepository.add(fruitDto));
		
		return "redirect:/fruits/add";
	}
}
