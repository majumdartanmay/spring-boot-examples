package com.hibernate.spring.test.sprint.hibernate.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RestController
	public static class HelloController {

		@GetMapping("/hello")
		public String hello() {
			return "ok";
		}
	}

}
