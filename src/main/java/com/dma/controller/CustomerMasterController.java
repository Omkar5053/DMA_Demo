package com.dma.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//........................
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import org.springframework.web.client.RestTemplate;

//..........................

import com.dma.entities.CustomerMaster;
import com.dma.repository.CustomerMasterRepository;

@RestController
@RequestMapping("/dma")
@CrossOrigin(origins = "*")
public class CustomerMasterController {

	@Autowired
	private CustomerMasterRepository customerMasterRepository;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerMaster customer)
	{
		customerMasterRepository.save(customer);
		return new ResponseEntity<String>("Customer added..",HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByEmail/{email}")
	public CustomerMaster getCustomerByEmailId(@PathVariable (value="email") String email)
	{
		return customerMasterRepository.findCustomerMasterByEmail(email);
	}
	

	
	
}
