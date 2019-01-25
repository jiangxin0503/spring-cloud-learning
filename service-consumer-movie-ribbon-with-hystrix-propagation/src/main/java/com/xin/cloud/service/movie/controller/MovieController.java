package com.xin.cloud.service.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xin.cloud.service.movie.model.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback", 
		commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")) // 默认是个例策略，这个配置是指当前的controller接收和command在同一个线程池
	public User findById(@PathVariable Long id) {
		// http://localhost:7900/simple/
		// VIP virtual IP
		// HAProxy Heartbeat
		return this.restTemplate.getForObject("http://service-user/simple/" + id, User.class);
	}

	public User findByIdFallback(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}
}
