package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.actuate.observability.AutoConfigureObservability;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureObservability
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	WebTestClient testClient;

	@RepeatedTest(10)
	void testWebTestClientMemoryLeak() {
		testClient.get().uri("/warn").exchange().expectStatus().isOk();
	}

	@AfterEach
	void callGC() {
		// Force GC. Memory leaks are detected where reference is removed from memory
		System.gc();
	}

}
