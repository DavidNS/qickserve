package com.dns.qikserve.baskets.outDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ItemOutDTOTest {

	@Test
	void constructorEmpty() {
		ItemOutDTO instance = new ItemOutDTO();
		assertNotNull(instance);
	}

	@Test
	void constructorAllArgs() {
		ItemOutDTO instance = new ItemOutDTO("A", "A", 0.0, 0);
		assertNotNull(instance);
	}

	@Test
	void getId() {
		String expectedID = "A";
		ItemOutDTO instance = new ItemOutDTO(expectedID, "A", 0.0, 0);
		assertEquals(expectedID, instance.getId());
	}

	@Test
	void getName() {
		String expectedName = "A";
		ItemOutDTO instance = new ItemOutDTO("A", expectedName, 0.0, 0);
		assertEquals(expectedName, instance.getName());
	}

	@Test
	void getPrice() {
		Double expectedPrice = 0.0;
		ItemOutDTO instance = new ItemOutDTO("A", "A", expectedPrice, 0);
		assertEquals(expectedPrice, instance.getPrice());
	}

	@Test
	void getCount() {
		Integer expectedCount = 0;
		ItemOutDTO instance = new ItemOutDTO("A", "A", 0.0, expectedCount);
		assertEquals(expectedCount, instance.getCount());
	}

}
