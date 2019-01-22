package com.xin.cloud.service.normal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xin.cloud.service.normal.user.model.User;
import com.xin.cloud.service.normal.user.repository.UserRepository;



@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findById(id).get();
	}
}
