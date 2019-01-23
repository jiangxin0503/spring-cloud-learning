package com.xin.cloud.service.movie.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.xin.cloud.service.movie.annotation.ExcludeFromComponentScan;

@Configuration
@ExcludeFromComponentScan
public class ServiceUserConfiguration {
	
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}