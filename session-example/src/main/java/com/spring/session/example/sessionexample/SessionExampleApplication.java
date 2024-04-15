package com.spring.session.example.sessionexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisServer;

@SpringBootApplication
public class SessionExampleApplication {
	public static void main(String[] args) {
		new RedisServer("127.0.0.1", 6379);
		SpringApplication.run(SessionExampleApplication.class, args);
	}

}
