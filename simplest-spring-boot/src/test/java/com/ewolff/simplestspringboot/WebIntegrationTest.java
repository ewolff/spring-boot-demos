package com.ewolff.simplestspringboot;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ControllerAndMain.class)
@IntegrationTest
@WebAppConfiguration
public class WebIntegrationTest {

	@Test
	public void homePage() {
		RestTemplate restTemplate = new RestTemplate();
		assertEquals("hello", restTemplate.getForObject(
				"http://127.0.0.1:8080", String.class));
	}

}
