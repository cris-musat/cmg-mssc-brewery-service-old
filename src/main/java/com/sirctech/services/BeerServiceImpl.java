package com.sirctech.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sirctech.web.models.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {

	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID()).name("beer name").style("beer style").build();
	}

}
