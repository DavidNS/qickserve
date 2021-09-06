package com.dns.qikserve.baskets.wiremockclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ItemWireOutDTOTest {

	@Test
	void constructor() {
		ItemWireOutDTO instance=new ItemWireOutDTO();
		assertNotNull(instance);
	}
	
	@Test
	void getId() {
		ItemWireOutDTO instance=new ItemWireOutDTO();
		assertNull(instance.getId());
	}

	@Test
	void getName() {
		ItemWireOutDTO instance=new ItemWireOutDTO();
		assertNull(instance.getName());
	}
	
	@Test
	void getPrice() {
		ItemWireOutDTO instance=new ItemWireOutDTO();
		assertNull(instance.getPrice());
	}
	
	@Test
	void getPromotions() {
		ItemWireOutDTO instance=new ItemWireOutDTO();
		assertNotNull(instance.getPromotions());
	}
	
	@Test
	void setId() {
		String expected="A";
		ItemWireOutDTO instance=new ItemWireOutDTO();
		instance.setId(expected);
		assertEquals(expected, instance.getId());
	}

	@Test
	void setName() {
		String expected="A";
		ItemWireOutDTO instance=new ItemWireOutDTO();
		instance.setName(expected);
		assertEquals(expected, instance.getName());
	}
	
	@Test
	void setPrice() {
		Double expected=1.0;
		ItemWireOutDTO instance=new ItemWireOutDTO();
		instance.setPrice(expected);
		assertEquals(expected, instance.getPrice());
	}
	
	@Test
	void setPromotions() {
		ArrayList<PromotionWireOutDTO> expected=new ArrayList<>();
		ItemWireOutDTO instance=new ItemWireOutDTO();
		instance.setPromotions(expected);
		assertEquals(expected, instance.getPromotions());
	}
	
}
