package com.dns.qikserve.baskets.promotionsCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.FlatPercentOutDTO;

class FlatPercentTest {

	@Test
	void constructor() {
		FlatPercent flatPercent=new FlatPercent();
		assertNotNull(flatPercent);
	}
	
	@Test
	void flatPercentApplied10() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		String priceString=String.valueOf(itemWirePrice);
		Integer percentI=10;
		String percentS="0.1";
		applyTest(itemWireID, itemWirePrice, priceString, percentI, percentS);
	}
	
	@Test
	void flatPercentApplied28() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		String priceString=String.valueOf(itemWirePrice);
		Integer percentI=28;
		String percentS="0.28";
		applyTest(itemWireID, itemWirePrice, priceString, percentI, percentS);
	}
	
	
	@Test
	void flatPercentApplied93() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		String priceString=String.valueOf(itemWirePrice);
		Integer percentI=93;
		String percentS="0.93";
		applyTest(itemWireID, itemWirePrice, priceString, percentI, percentS);
	}
	
	private void applyTest(String itemWireID, Double itemWirePrice, String priceString, Integer percentI,
			String percentS) {
		Double expected=new BigDecimal(priceString).multiply(new BigDecimal(percentS)).doubleValue();
		
		ItemWireOutDTO item = newItemWire(itemWireID, itemWirePrice);
		BasketEntity basket = new BasketEntity();
		FlatPercentOutDTO promotion= newPromotion(percentI);

		FlatPercent instance = new FlatPercent();
		Double result = instance.addItem(basket, item, promotion);
		assertEquals(expected,result);
	}

	private FlatPercentOutDTO newPromotion(Integer ammount) {
		FlatPercentOutDTO promotions = new FlatPercentOutDTO();
		promotions.setAmount(ammount);
		return promotions;
	}

	private ItemWireOutDTO newItemWire(String itemWireID, Double itemWirePrice) {
		ItemWireOutDTO itemWireDTO = new ItemWireOutDTO();
		itemWireDTO.setId(itemWireID);
		itemWireDTO.setPrice(itemWirePrice);
		return itemWireDTO;
	}
}
