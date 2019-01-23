package com.xin.cloud.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.xin.cloud.service.user.model.User;
import com.xin.cloud.service.user.repository.UserRepository;


@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findById(id).get();
	}
	// from the implementation of Eureka API
	@Autowired
	private EurekaClient eurekaClient;
	// from the Spring cloud Standard API
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SERVICE-USER", false);
		return instance.getHomePageUrl();
	}

	@GetMapping("/instance-info")
	public List<ServiceInstance> getServiceInstances() {
		List<ServiceInstance> serviceInstances= discoveryClient.getInstances("SERVICE-USER");
		return serviceInstances;
	}

}
