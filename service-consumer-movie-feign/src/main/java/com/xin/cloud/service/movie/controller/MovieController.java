package com.xin.cloud.service.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xin.cloud.service.movie.feign.UserFeignClient;
import com.xin.cloud.service.movie.model.User;

@RestController
public class MovieController {
	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.userFeignClient.findById(id);
	}

	@PostMapping("/test-post")
	public User testPost(User user) {
		return this.userFeignClient.postUser(user);
	}

	@GetMapping("/test-get")
	public User testGet(User user) {
		return this.userFeignClient.getUser(user);
	}
}
