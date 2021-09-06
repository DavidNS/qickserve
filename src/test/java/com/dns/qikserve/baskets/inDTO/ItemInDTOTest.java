package com.dns.qikserve.baskets.inDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ItemInDTOTest {

	@Test
	void constructorNoArgs() {
		ItemInDTO instance = new ItemInDTO();
		assertNotNull(instance);
	}

	@Test
	void constructorAllArgs() {
		String expected = "A";
		ItemInDTO instance = new ItemInDTO(expected);

		assertEquals(expected, instance.getItemID());
	}

	@Test
	void getID() {
		ItemInDTO instance = new ItemInDTO();
		assertNull(instance.getItemID());
	}

}
