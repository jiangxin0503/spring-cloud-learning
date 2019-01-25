package com.xin.cloud.service.movie.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import feign.Contract;
import feign.Feign;

public class FeignClientWithCustomContractConfiguration {
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
