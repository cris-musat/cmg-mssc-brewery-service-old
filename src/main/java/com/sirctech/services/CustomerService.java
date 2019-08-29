package com.sirctech.services;

import java.util.UUID;

import com.sirctech.web.models.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveCustomer(CustomerDto customerDto);

	void updateCustomer(UUID customerId);

	void deleteCustomer(UUID customerId);

}
