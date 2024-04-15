package com.spring.session.example.sessionexample;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SessionExampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SessionExampleApplicationTests {
	private Jedis jedis;
	private static RedisServer redisServer;
	private TestRestTemplate testRestTemplate;
	private TestRestTemplate testRestTemplateWithAuth;
	private String testUrl = "http://localhost:8080/hello";

	private static int redisPort = 6379;
	@BeforeAll
	public static void startRedisServer() throws IOException {
		redisServer = new RedisServer(redisPort);
		redisServer.start();
	}

	@AfterAll
	public static void stopRedisServer() {
		redisServer.stop();
	}

	@LocalServerPort
	private int localServerPort;
	@BeforeEach
	public void clearRedisData() {
		testRestTemplate = new TestRestTemplate();

		final TestRestTemplate.HttpClientOption option = null;
		testRestTemplateWithAuth = new TestRestTemplate("admin", "password", option);

		jedis = new Jedis("127.0.0.1", redisPort);
		jedis.flushAll();
	}
	@Test
	public void redisIsCleared() {
		final Set<String> keys = jedis.keys("*");
		assertTrue(keys.isEmpty());
	}

	@Test
	public void unauthenticatedRequest() {
		ResponseEntity<String> result = testRestTemplate.getForEntity(testUrl, String.class);
		assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
	}
}
