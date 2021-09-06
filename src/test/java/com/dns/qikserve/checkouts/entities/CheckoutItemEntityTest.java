package com.dns.qikserve.checkouts.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CheckoutItemEntityTest {

	@Test
	void constructor() {
		CheckoutItemEntity instance=new CheckoutItemEntity();
		assertNotNull(instance);
	}

	@Test
	void getId() {
		CheckoutItemEntity instance=new CheckoutItemEntity();
		assertNull(instance.getId());
	}
	
	@Test
	void getName() {
		CheckoutItemEntity instance=new CheckoutItemEntity();
		assertNull(instance.getName());
	}
	
	@Test
	void getPrice() {
		CheckoutItemEntity instance=new CheckoutItemEntity();
		assertNull(instance.getPrice());
	}
	
	@Test
	void getCount() {
		CheckoutItemEntity instance=new CheckoutItemEntity();
		assertNull(instance.getCount());
	}
	
	@Test
	void setId() {
		String expected="A";
		CheckoutItemEntity instance=new CheckoutItemEntity();
		instance.setId(expected);
		String result=instance.getId();
		assertEquals(expected,result);
	}
	
	@Test
	void setName() {
		String expected="A";
		CheckoutItemEntity instance=new CheckoutItemEntity();
		instance.setName(expected);
		String result=instance.getName();
		assertEquals(expected,result);
	}
	
	@Test
	void setPrice() {
		Double expected=1.0;
		CheckoutItemEntity instance=new CheckoutItemEntity();
		instance.setPrice(expected);
		Double result=instance.getPrice();
		assertEquals(expected,result);
	}
	
	@Test
	void setCount() {
		Integer expected=1;
		CheckoutItemEntity instance=new CheckoutItemEntity();
		instance.setCount(expected);
		Integer result=instance.getCount();
		assertEquals(expected,result);
	}
	
}
