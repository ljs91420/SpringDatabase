package com.ezen.springdata.profile.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProfileImageDTO {
	private Integer id;
	private String originalFilename;
	private String storedFilename;
	private MultipartFile profileImageFile;
	private List<MultipartFile> profileImageFiles;
}
