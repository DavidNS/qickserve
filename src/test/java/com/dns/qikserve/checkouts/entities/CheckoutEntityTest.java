package com.dns.qikserve.checkouts.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CheckoutEntityTest {

	@Test
	void constructor() {
		CheckoutEntity instance=new CheckoutEntity();
		assertNotNull(instance);
	}

	@Test
	void getCheckoutID() {
		CheckoutEntity instance=new CheckoutEntity();
		assertNull(instance.getCheckoutID());
	}
	
	@Test
	void getItems() {
		CheckoutEntity instance=new CheckoutEntity();
		assertNull(instance.getItems());
	}
	
	@Test
	void getRawTotal() {
		CheckoutEntity instance=new CheckoutEntity();
		assertNotNull(instance.getRawTotal());
	}
	
	@Test
	void getTotalPromos() {
		CheckoutEntity instance=new CheckoutEntity();
		assertNotNull(instance.getTotalPromos());
	}
	
	@Test
	void getTotalPayable() {
		CheckoutEntity instance=new CheckoutEntity();
		assertNotNull(instance.getTotalPayable());
	}
	
	@Test
	void setCheckoutID() {
		Integer expected=1;
		CheckoutEntity instance=new CheckoutEntity();
		instance.setCheckoutID(expected);
		Integer result=instance.getCheckoutID();
		assertEquals(expected, result);
	}
	
	@Test
	void setItems() {
		List<CheckoutItemEntity> expected=new ArrayList<>();
		CheckoutEntity instance=new CheckoutEntity();
		instance.setItems(expected);
		List<CheckoutItemEntity> result=instance.getItems();
		assertEquals(expected, result);
	}
	
	@Test
	void setRawTotal() {
		Double expected=1.0;
		CheckoutEntity instance=new CheckoutEntity();
		instance.setRawTotal(expected);
		Double result=instance.getRawTotal();
		assertEquals(expected, result);
	}
	
	@Test
	void setTotalPromos() {
		Double expected=1.0;
		CheckoutEntity instance=new CheckoutEntity();
		instance.setTotalPromos(expected);
		Double result=instance.getTotalPromos();
		assertEquals(expected, result);
	}
	
	@Test
	void setTotalPayable() {
		Double expected=1.0;
		CheckoutEntity instance=new CheckoutEntity();
		instance.setTotalPayable(expected);
		Double result=instance.getTotalPayable();
		assertEquals(expected, result);
	}
	
}
