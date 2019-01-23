package com.xin.cloud.service.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xin.cloud.service.movie.model.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;


	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
	    // http://localhost:7900/simple/
	    // VIP virtual IP
	    // HAProxy Heartbeat
	    return this.restTemplate.getForObject("http://service-user:7900/simple/" + id, User.class);
	}
}
