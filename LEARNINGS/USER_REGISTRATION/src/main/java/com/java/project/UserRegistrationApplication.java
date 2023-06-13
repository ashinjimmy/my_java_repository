package com.java.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserRegistrationApplication {

	public static void main(String[] args) {
		
		
		String password = "ashin";
		System.out.println(new BCryptPasswordEncoder().encode(password));
		
		
	//	SpringApplication.run(UserRegistrationApplication.class, args);
		
		
		
	}

}
