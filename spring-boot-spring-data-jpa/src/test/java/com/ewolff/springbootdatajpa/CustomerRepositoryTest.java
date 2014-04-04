package com.ewolff.springbootdatajpa;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ewolff.springbootdatajpa.ControllerAndMain;
import com.ewolff.springbootdatajpa.domain.Customer;
import com.ewolff.springbootdatajpa.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ControllerAndMain.class)
@Transactional
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository; 
	
	@Test
	public void createAndQuery() {
		assertEquals(1, customerRepository.findByName("Wolff").size());
		customerRepository.save(new Customer("Wolff", "Eberhard"));
		assertEquals(2, customerRepository.findByName("Wolff").size());
	}

}
