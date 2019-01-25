package com.xin.cloud.service.movie.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xin.cloud.service.movie.feign.config.FeignClientWithCustomBasicAuthConfiguration;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", 
	configuration = FeignClientWithCustomBasicAuthConfiguration.class, 
	fallback = HystrixClientFallback.class)
public interface FeignClientWithCustomBasicAuthRequestInterceptor {
	@RequestMapping(value = "/eureka/apps/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
