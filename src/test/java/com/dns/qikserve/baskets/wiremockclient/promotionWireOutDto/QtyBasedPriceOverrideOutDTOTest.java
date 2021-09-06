package com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.dns.qikserve.baskets.PromotionWireType;

class QtyBasedPriceOverrideOutDTOTest {

	@Test
	void testQtyBasedPriceOverrideOutDTO() {
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		assertNotNull(instance);
	}
	
	@Test
	void testGetRequired_qty() {
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		assertNull(instance.getRequired_qty());
	}
	
	@Test
	void testSetRequired_qty() {
		Integer expected=1;
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		instance.setRequired_qty(expected);
		assertEquals(expected,instance.getRequired_qty());
	}

	@Test
	void testGetPrice() {
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		assertNull(instance.getPrice());
	}

	@Test
	void testSetPrice() {
		Integer expected=1;
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		instance.setPrice(expected);
		assertEquals(expected,instance.getPrice());
	}

	@Test
	void testGetId() {
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		assertNull(instance.getId());
	}
	
	@Test
	void testSetId() {
		String expected="A";
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		instance.setId(expected);
		assertEquals(expected,instance.getId());
	}

	@Test
	void testGetType() {
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		assertNull(instance.getType());
	}

	@Test
	void testSetType() {
		PromotionWireType expected=PromotionWireType.BUY_X_GET_Y_FREE;
		QtyBasedPriceOverrideOutDTO instance=new QtyBasedPriceOverrideOutDTO();
		instance.setType(expected);
		assertEquals(expected,instance.getType());
	}



}
