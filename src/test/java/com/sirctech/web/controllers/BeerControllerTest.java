package com.sirctech.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirctech.services.BeerService;
import com.sirctech.web.models.BeerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@MockBean
	BeerService beerService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	BeerDto validBeer;

	@Before
	public void setUp() {
		validBeer = BeerDto.builder().id(UUID.randomUUID()).name("Beer1").style("PALE_ALE").upc(123456789012L).build();
	}

	@Test
	public void testGetBeerbyId() throws Exception {
		given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

		mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
				.andExpect(jsonPath("$.name", is("Beer1")));
	}

	@Test
	public void testSaveBeer() {

	}

	@Test
	public void testUpdateBeer() {

	}

	@Test
	public void testDeletBeer() {

	}

}
