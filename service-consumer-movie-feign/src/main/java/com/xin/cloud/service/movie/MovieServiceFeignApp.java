package com.xin.cloud.service.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieServiceFeignApp {
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceFeignApp.class, args);
	}
}
