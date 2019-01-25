package com.xin.cloud.service.movie.feign.config;

import org.springframework.context.annotation.Bean;

import feign.Contract;

public class FeignClientWithCustomContractConfiguration {
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
}
