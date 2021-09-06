package com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.dns.qikserve.baskets.PromotionWireType;

class FlatPercentOutDTOTest {

	@Test
	void testFlatPercentOutDTO() {
		FlatPercentOutDTO instance=new FlatPercentOutDTO();
		assertNotNull(instance);
	}

	
	@Test
	void testGetAmount() {
		FlatPercentOutDTO instance=new FlatPercentOutDTO();
		assertNull(instance.getAmount());
	}

	@Test
	void testSetAmount() {
		Integer expected=1;
		FlatPercentOutDTO instance=new FlatPercentOutDTO();
		instance.setAmount(expected);
		assertEquals(expected,instance.getAmount());
	}

	@Test
	void testGetId() {
		FlatPercentOutDTO instance=new FlatPercentOutDTO();
		assertNull(instance.getId());
	}
	
	@Test
	void testSetId() {
		String expected="A";
		FlatPercentOutDTO instance=new FlatPercentOutDTO();
		instance.setId(expected);
		assertEquals(expected,instance.getId());
	}

	@Test
	void testGetType() {
		FlatPercentOutDTO instance=new FlatPercentOutDTO();
		assertNull(instance.getType());
	}

	@Test
	void testSetType() {
		PromotionWireType expected=PromotionWireType.BUY_X_GET_Y_FREE;
		FlatPercentOutDTO instance=new FlatPercentOutDTO();
		instance.setType(expected);
		assertEquals(expected,instance.getType());
	}

}
