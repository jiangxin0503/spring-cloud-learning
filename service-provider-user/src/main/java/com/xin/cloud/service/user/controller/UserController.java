package com.xin.cloud.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

/*	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
		return instance.getHomePageUrl();
	}

	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
		return user;
	}

	// 该请求不会成功
	@GetMapping("/get-user")
	public User getUser(User user) {
		return user;
	}

	@GetMapping("list-all")
	public List<User> listAll() {
		ArrayList<User> list = Lists.newArrayList();
		User user = new User(1L, "zhangsan");
		User user2 = new User(2L, "zhangsan");
		User user3 = new User(3L, "zhangsan");
		list.add(user);
		list.add(user2);
		list.add(user3);
		return list;

	}*/
}
