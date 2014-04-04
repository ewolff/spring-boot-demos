package com.ewolff.springbootdatajpa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
