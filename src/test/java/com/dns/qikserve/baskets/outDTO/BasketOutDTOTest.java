package com.dns.qikserve.baskets.outDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BasketOutDTOTest {

	@Test
	void constructorNoArgs() {
		BasketOutDTO instance = new BasketOutDTO();
		assertNotNull(instance);
	}

	@Test
	void constructorAllArgs() {
		BasketOutDTO instance = new BasketOutDTO(0, new ArrayList<>(), 0.0, 0.0, 0.0);
		assertNotNull(instance);
	}

	@Test
	void getBasketID() {
		Integer expectedID = 1;
		BasketOutDTO instance = new BasketOutDTO(expectedID, new ArrayList<>(), 0.0, 0.0, 0.0);
		assertEquals(expectedID, instance.getBasketID());
	}

	@Test
	void getItems() {
		ArrayList<ItemOutDTO> expectedItems = new ArrayList<>();
		BasketOutDTO instance = new BasketOutDTO(0, expectedItems, 0.0, 0.0, 0.0);
		assertEquals(expectedItems, instance.getItems());
	}

	@Test
	void getRawTotal() {
		Double expectedRawTotal = 1.0;
		BasketOutDTO instance = new BasketOutDTO(0, new ArrayList<>(), expectedRawTotal, 0.0, 0.0);
		assertEquals(expectedRawTotal, instance.getRawTotal());
	}

	@Test
	void getTotalPromos() {
		Double expectedTotalPromos = 1.0;
		BasketOutDTO instance = new BasketOutDTO(0, new ArrayList<>(), 0.0, expectedTotalPromos, 0.0);
		assertEquals(expectedTotalPromos, instance.getTotalPromos());
	}

	@Test
	void getTotalPayable() {
		Double expectedTotalPayable = 1.0;
		BasketOutDTO instance = new BasketOutDTO(0, new ArrayList<>(), 0.0, 0.0, expectedTotalPayable);
		assertEquals(expectedTotalPayable, instance.getTotalPayable());
	}

}
