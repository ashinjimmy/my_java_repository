package com.java.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.java.project.controller.dto.UserRegistrationDto;
import com.java.project.entity.UserEntity;

public interface UserRegistrationService extends UserDetailsService {

	UserEntity save(UserRegistrationDto userRegistrationDto);
	
}
