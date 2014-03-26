package com.ewolff.springbootdatajpa;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ewolff.springbootdatajpa.domain.Customer;
import com.ewolff.springbootdatajpa.repository.CustomerRepository;

@Controller
@EnableAutoConfiguration
public class ControllerAndMain {

	private CustomerRepository customerRepository;
	
	@Autowired
	public ControllerAndMain(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		customerRepository.save(new Customer("Wolff","Eberhard"));
		customerRepository.save(new Customer("Johnson","Rod"));
	}
	
	@RequestMapping("/")
	public ModelAndView hello() {
		return new ModelAndView("customerlist","customers",customerRepository.findAll());
		//return new ModelAndView("customerlist","customers",new ArrayList<Customer>());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ControllerAndMain.class, args);
	}

}
