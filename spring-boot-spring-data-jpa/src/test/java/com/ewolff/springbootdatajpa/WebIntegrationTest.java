package com.ewolff.springbootdatajpa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControllerAndMain.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebIntegrationTest {

	@Value("${local.server.port}")
	private int serverPort;

	@Test
	public void homePage() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject("http://127.0.0.1:" + serverPort, String.class).contains("Wolff"));
	}

}
