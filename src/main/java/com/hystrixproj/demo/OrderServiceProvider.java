package com.hystrixproj.demo;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderServiceProvider {

	@GetMapping("/show")
	@HystrixCommand(fallbackMethod="showFallBack") 
	//parameter must be same as fallBackMethod name
	public String showMsg() {
	 System.out.println("From service");
	 int var = new Random().nextInt(10);
	 System.out.println(var);
	if (var<=10)
	{
	    throw new RuntimeException("DUMMY");
	}
	return "Hello From Provider";
	}

	//fallBack method
	public String showFallBack() {
	System.out.println("From fallback");
	return "From FallBack method";
	}


}
