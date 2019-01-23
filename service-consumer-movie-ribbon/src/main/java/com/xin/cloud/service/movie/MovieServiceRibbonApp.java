package com.xin.cloud.service.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.xin.cloud.service.movie.annotation.ExcludeFromComponentScan;
import com.xin.cloud.service.movie.confg.ServiceUserConfiguration;

@SpringBootApplication
@RibbonClient(name = "service-user", configuration = ServiceUserConfiguration.class)
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class MovieServiceRibbonApp {
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceRibbonApp.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
