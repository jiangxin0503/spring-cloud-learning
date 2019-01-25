package com.xin.cloud.service.movie.feign;

import org.springframework.stereotype.Component;

import com.xin.cloud.service.movie.model.User;

@Component
public class HystrixUserFeignClientFallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}

}
