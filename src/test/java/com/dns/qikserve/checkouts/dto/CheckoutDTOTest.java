package com.dns.qikserve.checkouts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CheckoutDTOTest {

	@Test
	void constructor() {
		CheckoutDTO instance=new CheckoutDTO();
		assertNotNull(instance);
	}

	@Test
	void getCheckoutID() {
		CheckoutDTO instance=new CheckoutDTO();
		assertNull(instance.getCheckoutID());
	}
	
	@Test
	void getItems() {
		CheckoutDTO instance=new CheckoutDTO();
		assertNull(instance.getItems());
	}
	
	@Test
	void getRawTotal() {
		CheckoutDTO instance=new CheckoutDTO();
		assertNull(instance.getRawTotal());
	}
	
	@Test
	void getTotalPromos() {
		CheckoutDTO instance=new CheckoutDTO();
		assertNull(instance.getTotalPromos());
	}
	
	@Test
	void getTotalPayable() {
		CheckoutDTO instance=new CheckoutDTO();
		assertNull(instance.getTotalPayable());
	}
	@Test
	void setCheckoutID() {
		Integer expected=1;
		CheckoutDTO instance=new CheckoutDTO();
		instance.setCheckoutID(expected);
		Integer result=instance.getCheckoutID();
		assertEquals(expected,result);
	}
	
	@Test
	void setItems() {
		List<ItemCheckoutDTO> expected=new ArrayList<>();
		CheckoutDTO instance=new CheckoutDTO();
		instance.setItems(expected);
		List<ItemCheckoutDTO> result=instance.getItems();
		assertEquals(expected,result);
	}
	
	@Test
	void setRawTotal() {
		Double expected=1.0;
		CheckoutDTO instance=new CheckoutDTO();
		instance.setRawTotal(expected);
		Double result=instance.getRawTotal();
		assertEquals(expected,result);
	}
	
	@Test
	void setTotalPromos() {
		Double expected=1.0;
		CheckoutDTO instance=new CheckoutDTO();
		instance.setTotalPromos(expected);
		Double result=instance.getTotalPromos();
		assertEquals(expected,result);
	}
	
	@Test
	void setTotalPayable() {
		Double expected=1.0;
		CheckoutDTO instance=new CheckoutDTO();
		instance.setTotalPayable(expected);
		Double result=instance.getTotalPayable();
		assertEquals(expected,result);
	}

	
}
