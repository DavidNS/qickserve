package com.dns.qikserve.baskets.promotionsCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.BuyXGetYFreeOutDTO;

class BuyXGetYFreeTest {

	@Test
	void constructor() {
		BuyXGetYFree instance = new BuyXGetYFree();
		assertNotNull(instance);
	}

	@Test
	void addItem2Req1FreeApplied() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		Integer currentQTY=1;
		Integer requiredQYT=2;
		Integer freeQTY=1;
		Double expected=itemWirePrice*freeQTY;
		
		ItemWireOutDTO item = newItemWire(itemWireID, itemWirePrice);
		BasketEntity basket = newBasketEntity(itemWireID, currentQTY);
		PromotionWireOutDTO promotion= newBuyXGetYFreeOutDTO(requiredQYT,freeQTY);

		BuyXGetYFree instance = new BuyXGetYFree();
		Double result = instance.addItem(basket, item, promotion);
		assertEquals(expected,result);
	}
	
	@Test
	void addItem2Req1FreeNotApplied() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		Integer currentQTY=0;
		Integer requiredQYT=2;
		Integer freeQTY=1;
		Double expected=0.0;
		
		ItemWireOutDTO item = newItemWire(itemWireID, itemWirePrice);
		BasketEntity basket = newBasketEntity(itemWireID, currentQTY);
		PromotionWireOutDTO promotion= newBuyXGetYFreeOutDTO(requiredQYT,freeQTY);

		BuyXGetYFree instance = new BuyXGetYFree();
		Double result = instance.addItem(basket, item, promotion);
		assertEquals(expected,result);
	}
	
	@Test
	void addItem5Req3FreeApplied() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		Integer currentQTY=4;
		Integer requiredQYT=5;
		Integer freeQTY=3;
		Double expected=itemWirePrice*freeQTY;
		
		ItemWireOutDTO item = newItemWire(itemWireID, itemWirePrice);
		BasketEntity basket = newBasketEntity(itemWireID, currentQTY);
		PromotionWireOutDTO promotion= newBuyXGetYFreeOutDTO(requiredQYT,freeQTY);

		BuyXGetYFree instance = new BuyXGetYFree();
		Double result = instance.addItem(basket, item, promotion);
		assertEquals(expected,result);
	}
	
	@Test
	void addItem5Req3FreeNotApplied() {
		String itemWireID = "A";
		Double itemWirePrice = 10.0;
		Integer currentQTY=3;
		Integer requiredQYT=5;
		Integer freeQTY=3;
		Double expected=0.0;
		
		ItemWireOutDTO item = newItemWire(itemWireID, itemWirePrice);
		BasketEntity basket = newBasketEntity(itemWireID, currentQTY);
		PromotionWireOutDTO promotion= newBuyXGetYFreeOutDTO(requiredQYT,freeQTY);

		BuyXGetYFree instance = new BuyXGetYFree();
		Double result = instance.addItem(basket, item, promotion);
		assertEquals(expected,result);
	}

	private BuyXGetYFreeOutDTO newBuyXGetYFreeOutDTO(Integer requiredQTY, Integer freeQTY) {
		BuyXGetYFreeOutDTO promotions = new BuyXGetYFreeOutDTO();
		promotions.setRequired_qty(requiredQTY);
		promotions.setFree_qty(freeQTY);
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
