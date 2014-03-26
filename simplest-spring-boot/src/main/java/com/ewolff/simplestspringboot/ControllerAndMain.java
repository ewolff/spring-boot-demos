package com.ewolff.simplestspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ControllerAndMain {

	@RequestMapping("/")
	public String hello() {
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(ControllerAndMain.class, args);
	}

}
