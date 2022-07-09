package com.dma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dma.entities.CustomerMaster;
import com.dma.repository.CustomerMasterRepository;

@RestController
@RequestMapping("/dma")
public class CustomerMasterController {

	@Autowired
	private CustomerMasterRepository customerMasterRepository;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerMaster customer)
	{
		customerMasterRepository.save(customer);
		return new ResponseEntity<String>("Customer added..",HttpStatus.CREATED);
	}
}
