package com.xin.cloud.service.movie.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.xin.cloud.service.movie.feign.config.FeignClientWithCustomContractConfiguration;
import com.xin.cloud.service.movie.model.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "service-user", configuration = FeignClientWithCustomContractConfiguration.class)
public interface FeignClientWithCustomContract {
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
}
