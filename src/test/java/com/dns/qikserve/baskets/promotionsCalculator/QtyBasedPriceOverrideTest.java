package com.dns.qikserve.baskets.promotionsCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.QtyBasedPriceOverrideOutDTO;

class QtyBasedPriceOverrideTest {

	@Test
	void test() {
		QtyBasedPriceOverride instance = new QtyBasedPriceOverride();
		assertNotNull(instance);
	}

	@Test
	void addItem5Req3FreeNotApplied() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		Integer currentQTY = 2;
		Integer requiredQYT = 5;
		Integer overridedPrice = 30;
		Double expected = 0.0;

		ItemWireOutDTO item = newItemWire(itemWireID, itemWirePrice);
		BasketEntity basket = newBasketEntity(itemWireID, currentQTY);
		PromotionWireOutDTO promotion = newPromotion(requiredQYT, overridedPrice);

		QtyBasedPriceOverride instance = new QtyBasedPriceOverride();
		Double result = instance.addItem(basket, item, promotion);
		assertEquals(expected, result);
	}
	
	@Test
	void addItem5Req3FreeApplied() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		Integer currentQTY = 4;
		Integer requiredQYT = 5;
		Integer overridedPrice = 30;
		
		BigDecimal defaultCost = new BigDecimal(String.valueOf(itemWirePrice)).multiply(new BigDecimal(String.valueOf(requiredQYT)));
		Double expected=defaultCost.subtract(new BigDecimal(String.valueOf(overridedPrice))).doubleValue();
		
		ItemWireOutDTO item = newItemWire(itemWireID, itemWirePrice);
		BasketEntity basket = newBasketEntity(itemWireID, currentQTY);
		PromotionWireOutDTO promotion = newPromotion(requiredQYT, overridedPrice);

		QtyBasedPriceOverride instance = new QtyBasedPriceOverride();
		Double result = instance.addItem(basket, item, promotion);
		assertEquals(expected, result);
	}

	private QtyBasedPriceOverrideOutDTO newPromotion(Integer requiredQTY, Integer price) {
		QtyBasedPriceOverrideOutDTO promotions = new QtyBasedPriceOverrideOutDTO();
		promotions.setRequired_qty(requiredQTY);
		promotions.setPrice(price);
		return promotions;
	}

	private BasketEntity newBasketEntity(String itemWireID, Integer currentItemQTY) {
		BasketEntity basketEntity = new BasketEntity();
		HashMap<String, Integer> itemIDVSCount = basketEntity.getItemIDVSItemCount();
		itemIDVSCount.put(itemWireID, currentItemQTY);
		return basketEntity;
	}

	private ItemWireOutDTO newItemWire(String itemWireID, Double itemWirePrice) {
		ItemWireOutDTO itemWireDTO = new ItemWireOutDTO();
		itemWireDTO.setId(itemWireID);
		itemWireDTO.setPrice(itemWirePrice);
		return itemWireDTO;
	}

}
