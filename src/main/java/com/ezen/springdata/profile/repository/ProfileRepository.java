package com.ezen.springdata.profile.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.profile.dto.ProfileImageDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ProfileRepository {
	private final SqlSessionTemplate sql;
	
	public void saveProfileImage(ProfileImageDTO profileImageDTO) {
		sql.insert("Profile.saveProfileImage", profileImageDTO);
	}
}
