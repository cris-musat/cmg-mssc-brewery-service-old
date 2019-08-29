package com.sirctech.web.controllers;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sirctech.services.CustomerService;
import com.sirctech.web.models.CustomerDto;

public class CustomerController {
	CustomerService service;

	public CustomerController(CustomerService customerService) {
		this.service = customerService;
	}

	@GetMapping({ "/{customerId}" })
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<CustomerDto>(service.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto savedCustomer = service.saveCustomer(customerDto);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + savedCustomer.getId());
		return new ResponseEntity<CustomerDto>(headers, HttpStatus.CREATED);
	}

	@PutMapping({"/{customerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable("customerId") UUID customerId){
		service.updateCustomer(customerId);
	}
	
	
	@DeleteMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("CustomerId") UUID customerId) {
		service.deleteCustomer(customerId);
	}
}

