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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sirctech.services.BeerService;
import com.sirctech.web.models.BeerDto;

@RestController
@RequestMapping("/api/v1/beer/")
public class BeerController {
	private BeerService service;

	public BeerController(BeerService service) {
		this.service = service;
	}

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDto> getBeerbyId(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<BeerDto>(service.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<BeerDto> saveBeer(@RequestBody BeerDto beerDto) {
		BeerDto newBeerDto = service.saveBeer(beerDto);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + newBeerDto.getId().toString());

		return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateBeer(@RequestBody BeerDto beerDto) {
		service.updateBeer(beerDto);
	}

	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletBeer(@PathVariable("beerId") UUID beerId) {
		service.deleteBeer(beerId);
	}

}
