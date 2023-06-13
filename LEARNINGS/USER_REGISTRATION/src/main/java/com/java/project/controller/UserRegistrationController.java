package com.java.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.project.controller.dto.UserRegistrationDto;
import com.java.project.service.UserRegistrationService;

@Controller
@RequestMapping("/signUp")
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;

	public UserRegistrationController(UserRegistrationService userRegistrationService) {
		super();
		this.userRegistrationService = userRegistrationService;
	}
	
	
	@ModelAttribute("userObject")
	public UserRegistrationDto userObject() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showSignUpPage() {
	//	System.out.println("-------------------------");
		return "signUp";
	}
	
	
	@PostMapping
	public String userAccountRegistration(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		System.out.println("-------------------------");
		userRegistrationService.save(registrationDto);
		return "redirect:/signUp?success";
	}

}
