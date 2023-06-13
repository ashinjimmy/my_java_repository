package com.java.project.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.project.controller.dto.UserRegistrationDto;
import com.java.project.entity.RoleEntity;
import com.java.project.entity.UserEntity;
import com.java.project.repository.UserRepository;
import com.java.project.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired // Filed based injection
	private UserRepository userRegistrationRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Constructor based injection
	public UserRegistrationServiceImpl(UserRepository userRegistrationRepository) {
		super();
		this.userRegistrationRepository = userRegistrationRepository;
	}

	@Override
	public UserEntity save(UserRegistrationDto userRegistrationDto) {

		UserEntity user = new UserEntity(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
				userRegistrationDto.getEmailId(), passwordEncoder.encode(userRegistrationDto.getPassword()),
				Arrays.asList(new RoleEntity("ROLE_USER")));

		return userRegistrationRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username --- "+username);
		UserEntity user = userRegistrationRepository.findByEmailId(username);
		System.out.println("user -- "+user);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid user name or password !!!");
		}
		return new User(user.getEmailId(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
