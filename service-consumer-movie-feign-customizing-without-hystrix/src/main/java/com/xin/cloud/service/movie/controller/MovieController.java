package com.xin.cloud.service.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xin.cloud.service.movie.feign.FeignClientWithCustomBasicAuthRequestInterceptor;
import com.xin.cloud.service.movie.feign.FeignClientWithCustomContract;
import com.xin.cloud.service.movie.model.User;

@RestController
public class MovieController {
	@Autowired
	private FeignClientWithCustomContract feignClientWithCustomContract;
	@Autowired
	private FeignClientWithCustomBasicAuthRequestInterceptor feignClientWithCustomBasicAuthRequestInterceptor;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.feignClientWithCustomContract.findById(id);
	}

	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
		return this.feignClientWithCustomBasicAuthRequestInterceptor
				.findServiceInfoFromEurekaByServiceName(serviceName);
	}

}
