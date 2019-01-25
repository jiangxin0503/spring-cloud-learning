package com.xin.cloud.service.movie.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xin.cloud.service.movie.model.User;

@FeignClient("service-user")
public interface UserFeignClient {
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id); // 一个坑： @PathVariable得设置value

	@PostMapping("/post-user")
	public User postUser(@RequestBody User user);

	// 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求
	@GetMapping("/get-user")
	public User getUser(User user);

}
