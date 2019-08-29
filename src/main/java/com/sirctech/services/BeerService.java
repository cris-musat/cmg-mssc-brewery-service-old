package com.sirctech.services;

import java.util.UUID;

import com.sirctech.web.models.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID beerId);

	BeerDto saveBeer(BeerDto beerDto);

	BeerDto updateBeer(BeerDto beerDto);

	void deleteBeer(UUID beerId);
}
