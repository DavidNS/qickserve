package com.dns.qikserve.baskets.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class BasketEntityTest {

	@Test
	void constructor() {
		BasketEntity instance = new BasketEntity();
		assertNotNull(instance);
	}

	@Test
	void getBasktetID() {
		BasketEntity instance = new BasketEntity();
		assertEquals(instance.getBasktetID(), null);
	}

	@Test
	void getItemIDVSItemCount() {
		BasketEntity instance = new BasketEntity();
		assertNotNull(instance.getItemIDVSItemCount());
	}

	@Test
	void getItemIDVSItemDescription() {
		BasketEntity instance = new BasketEntity();
		assertNotNull(instance.getItemIDVSItemDescription());
	}

	@Test
	void getRawTotal() {
		BasketEntity instance = new BasketEntity();
		assertEquals(0.0, instance.getRawTotal());
	}

	@Test
	void getTotalPromos() {
		BasketEntity instance = new BasketEntity();
		assertEquals(0.0, instance.getTotalPromos());
	}

	@Test
	void getTotalPayable() {
		BasketEntity instance = new BasketEntity();
		assertEquals(0.0, instance.getTotalPayable());
	}

	@Test
	void setBasktetID() {
		BasketEntity instance = new BasketEntity();
		Integer expectedID = 1;
		instance.setBasktetID(expectedID);
		assertEquals(expectedID, instance.getBasktetID());
	}

	@Test
	void setItemIDVSItemCount() {
		BasketEntity instance = new BasketEntity();
		HashMap<String, Integer> expectedItemIDVSCount = new HashMap<>();
		instance.setItemIDVSItemCount(expectedItemIDVSCount);
		assertEquals(expectedItemIDVSCount, instance.getItemIDVSItemCount());
	}

	@Test
	void setItemIDVSItemDescription() {
		BasketEntity instance = new BasketEntity();
		HashMap<String, BasketItemEntity> expectedItemIDVSDescription = new HashMap<>();
		instance.setItemIDVSItemDescription(expectedItemIDVSDescription);
		assertEquals(expectedItemIDVSDescription, instance.getItemIDVSItemDescription());
	}

	@Test
	void setRawTotal() {
		BasketEntity instance = new BasketEntity();
		Double expectedValue = 1.0;
		instance.setRawTotal(expectedValue);
		assertEquals(expectedValue, instance.getRawTotal());
	}

	@Test
	void setTotalPromos() {
		BasketEntity instance = new BasketEntity();
		Double expectedValue = 1.0;
		instance.setTotalPromos(expectedValue);
		assertEquals(expectedValue, instance.getTotalPromos());
	}

	@Test
	void setTotalPayable() {
		BasketEntity instance = new BasketEntity();
		Double expectedValue = 1.0;
		instance.setTotalPayable(expectedValue);
		assertEquals(expectedValue, instance.getTotalPayable());
	}

}
