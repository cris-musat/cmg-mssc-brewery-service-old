package com.sirctech.web.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.Console;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testGetBeerbyId() {
		String uuid = UUID.randomUUID().toString();
		try {
			mockMvc.perform(get("/api/v1/beer/" + uuid).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		} catch (Exception e) {
			System.out.println("ERROR: " + e + " UUID: "+ uuid);
		}
	}

	@Test
	void testSaveBeer() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletBeer() {
		fail("Not yet implemented");
	}

}
