package com.dns.qikserve.checkouts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ItemCheckoutDTOTest {

	@Test
	void constructor() {
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		assertNotNull(instance);
	}
	
	@Test
	void getID() {
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		assertNull(instance.getId());
	}
	
	@Test
	void getName() {
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		assertNull(instance.getName());
	}
	
	@Test
	void getPrice() {
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		assertNull(instance.getPrice());
	}
	
	@Test
	void getCount() {
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		assertNull(instance.getCount());
	}

	@Test
	void setId() {
		String expected="A";
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		instance.setId(expected);
		String result=instance.getId();
		assertEquals(expected, result);
	}
	
	@Test
	void setName() {
		String expected="A";
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		instance.setName(expected);
		String result=instance.getName();
		assertEquals(expected, result);
	}
	
	@Test
	void setPrice() {
		Double expected=1.0;
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		instance.setPrice(expected);
		Double result=instance.getPrice();
		assertEquals(expected, result);
	}
	
	@Test
	void setCount() {
		Integer expected=1;
		ItemCheckoutDTO instance=new ItemCheckoutDTO();
		instance.setCount(expected);
		Integer result=instance.getCount();
		assertEquals(expected, result);
	}
	
}
