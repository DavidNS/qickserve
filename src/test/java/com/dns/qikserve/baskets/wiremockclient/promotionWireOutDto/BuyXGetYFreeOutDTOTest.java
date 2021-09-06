package com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.dns.qikserve.baskets.PromotionWireType;

class BuyXGetYFreeOutDTOTest {

	@Test
	void testBuyXGetYFreeOutDTO() {
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		assertNotNull(instance);
	}
	
	@Test
	void testGetRequired_qty() {
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		assertNull(instance.getRequired_qty());
	}
	
	@Test
	void testSetRequired_qty() {
		Integer expected=1;
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		instance.setRequired_qty(expected);
		assertEquals(expected,instance.getRequired_qty());
	}

	@Test
	void testGetFree_qty() {
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		assertNull(instance.getFree_qty());
	}

	@Test
	void testSetFree_qty() {
		Integer expected=1;
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		instance.setFree_qty(expected);
		assertEquals(expected,instance.getFree_qty());
	}

	@Test
	void testGetId() {
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		assertNull(instance.getId());
	}
	
	@Test
	void testSetId() {
		String expected="A";
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		instance.setId(expected);
		assertEquals(expected,instance.getId());
	}

	@Test
	void testGetType() {
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		assertNull(instance.getType());
	}

	@Test
	void testSetType() {
		PromotionWireType expected=PromotionWireType.BUY_X_GET_Y_FREE;
		BuyXGetYFreeOutDTO instance=new BuyXGetYFreeOutDTO();
		instance.setType(expected);
		assertEquals(expected,instance.getType());
	}

}
