package com.ezen.springdata.profile.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.springdata.profile.dto.ProfileImageDTO;
import com.ezen.springdata.profile.service.ProfileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class ProfileController {
	private final ProfileService profileService;
	
	@GetMapping("/profile/image/upload")
	public String profileImageUploadPage() {
		return "/profile/upload_image";
	}
	
	@PostMapping("/profile/image/save")
	public String profileImageSave(ProfileImageDTO profileImageDTO) {
		log.info("profileImageDTO={}", profileImageDTO);
		try {
			profileService.save(profileImageDTO);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/profile/image/upload";
	}
}
