package com.xin.cloud.service.movie.feign;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback  implements FeignClientWithCustomBasicAuthRequestInterceptor {

	@Override
	public String findServiceInfoFromEurekaByServiceName(String serviceName) {
		return "dummy service";
	}
}
