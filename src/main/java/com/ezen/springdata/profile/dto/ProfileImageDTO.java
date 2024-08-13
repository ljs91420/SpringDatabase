package com.ezen.springdata.profile.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProfileImageDTO {
	private Integer id;
	private String originalFilename;
	private String storedFilename;
	private MultipartFile profileImageFile;
}
