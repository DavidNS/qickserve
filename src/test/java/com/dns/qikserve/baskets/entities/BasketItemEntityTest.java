package com.dns.qikserve.baskets.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BasketItemEntityTest {

	@Test
	void constructor() {
		BasketItemEntity instance = new BasketItemEntity();
		assertNotNull(instance);
	}

	@Test
	void getID() {
		BasketItemEntity instance = new BasketItemEntity();
		assertNull(instance.getId());
	}

	@Test
	void getName() {
		BasketItemEntity instance = new BasketItemEntity();
		assertNull(instance.getName());
	}

	@Test
	void getPrice() {
		BasketItemEntity instance = new BasketItemEntity();
		assertNull(instance.getPrice());
	}

	@Test
	void setId() {
		BasketItemEntity instance = new BasketItemEntity();
		String expectedID = "A";
		instance.setId(expectedID);
		assertEquals(expectedID, instance.getId());
	}

	@Test
	void setName() {
		BasketItemEntity instance = new BasketItemEntity();
		String expectedName = "A";
		instance.setName(expectedName);
		assertEquals(expectedName, instance.getName());
	}

	@Test
	void setPrice() {
		BasketItemEntity instance = new BasketItemEntity();
		Double expected = 1.0;
		instance.setPrice(expected);
		assertEquals(expected, instance.getPrice());
	}

}
