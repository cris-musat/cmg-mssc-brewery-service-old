package com.sirctech.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sirctech.web.models.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {

	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID()).name("beer - rest service").style("style beer - rest serice").build();
	}

	public BeerDto saveBeer(BeerDto beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public BeerDto updateBeer(BeerDto beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

}
