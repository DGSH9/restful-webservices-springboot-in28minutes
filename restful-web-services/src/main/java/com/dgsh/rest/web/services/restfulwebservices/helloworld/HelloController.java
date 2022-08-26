package com.dgsh.rest.web.services.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//Simple Get API
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Controller";
	}
	
	
	
	//Getmaping with Bean Class
	@GetMapping("/hello-bean")
	public HelloBean helloBean() {
		return new HelloBean("Hello From Bean");
	}
	
	
}
