package com.ewolff.simplestspringboot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ControllerAndMain.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class WebIntegrationTest {

	@Value("${local.server.port}")
	private int serverPort;
	
	@Test
	public void homePage() {
		RestTemplate restTemplate = new RestTemplate();
		assertEquals("hello", restTemplate.getForObject(
				"http://127.0.0.1:"+serverPort, String.class));
	}

}
