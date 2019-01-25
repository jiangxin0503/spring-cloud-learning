package com.xin.cloud.service.movie.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xin.cloud.service.movie.model.User;

@FeignClient(name = "service-user", fallback = HystrixUserFeignClientFallback.class)
public interface UserFeignClient {
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id); // 一个坑： @PathVariable得设置value

}
