package com.dns.qikserve.baskets.promotionsCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

import com.dns.qikserve.baskets.PromotionWireType;
import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.BuyXGetYFreeOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.FlatPercentOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.QtyBasedPriceOverrideOutDTO;

@ExtendWith(MockitoExtension.class)
class PromotionCalculatorTest {
	
	@Mock
	ApplicationContext context;
	
	@Mock
	BuyXGetYFree buyXGetYFree;
	
	@Mock
	FlatPercent flatPercent;
	
	@Mock
	QtyBasedPriceOverride qtyBasedPriceOverride;
	
	PromotionCalculator instance;

	@BeforeEach
	void constructorFoo(){
		when(context.getBean(BuyXGetYFree.class)).thenReturn(buyXGetYFree);
		when(context.getBean(FlatPercent.class)).thenReturn(flatPercent);
		when(context.getBean(QtyBasedPriceOverride.class)).thenReturn(qtyBasedPriceOverride);
		instance=new PromotionCalculator(context);
	}
	
	@Test
	void constructor() {
		assertNotNull(instance);
	}
	
	@Test
	void addItemBuyXGetY() {
		Double expected=0.0;
		PromotionWireOutDTO promotion = new BuyXGetYFreeOutDTO();
		promotion.setType(PromotionWireType.BUY_X_GET_Y_FREE);
		BasketEntity basketEntity = new BasketEntity();
		ItemWireOutDTO itemWireDTO=newItemWire(promotion);
		
		Double result=instance.addItem(basketEntity, itemWireDTO);
		
		assertEquals(expected,result);
	}
	
	@Test
	void addItemFlatPercent() {
		Double expected=0.0;
		PromotionWireOutDTO promotion = new FlatPercentOutDTO();
		promotion.setType(PromotionWireType.FLAT_PERCENT);
		BasketEntity basketEntity = new BasketEntity();
		ItemWireOutDTO itemWireDTO=newItemWire(promotion);
		
		Double result=instance.addItem(basketEntity, itemWireDTO);
		
		assertEquals(expected,result);
	}

	@Test
	void addItemQtyBasedPriceOverride() {
		Double expected=0.0;
		PromotionWireOutDTO promotion = new QtyBasedPriceOverrideOutDTO();
		promotion.setType(PromotionWireType.QTY_BASED_PRICE_OVERRIDE);
		BasketEntity basketEntity = new BasketEntity();
		ItemWireOutDTO itemWireDTO=newItemWire(promotion);
		
		Double result=instance.addItem(basketEntity, itemWireDTO);
		
		assertEquals(expected,result);
	}
	
	@Test
	void addItemBuyXGetYMocked() {
		Double expected=1.0;
		PromotionWireOutDTO promotion = new BuyXGetYFreeOutDTO();
		promotion.setType(PromotionWireType.BUY_X_GET_Y_FREE);
		BasketEntity basketEntity = new BasketEntity();
		ItemWireOutDTO itemWireDTO=newItemWire(promotion);
		
		when(buyXGetYFree.addItem(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(expected);
		Double result=instance.addItem(basketEntity, itemWireDTO);
		
		assertEquals(expected,result);
	}
	
	@Test
	void addItemFlatPercentMocked() {
		Double expected=1.0;
		PromotionWireOutDTO promotion = new FlatPercentOutDTO();
		promotion.setType(PromotionWireType.FLAT_PERCENT);
		BasketEntity basketEntity = new BasketEntity();
		ItemWireOutDTO itemWireDTO=newItemWire(promotion);
		
		when(flatPercent.addItem(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(expected);
		Double result=instance.addItem(basketEntity, itemWireDTO);
		
		assertEquals(expected,result);
	}

	@Test
	void addItemQtyBasedPriceOverrideMocked() {
		Double expected=1.0;
		PromotionWireOutDTO promotion = new QtyBasedPriceOverrideOutDTO();
		promotion.setType(PromotionWireType.QTY_BASED_PRICE_OVERRIDE);
		BasketEntity basketEntity = new BasketEntity();
		ItemWireOutDTO itemWireDTO=newItemWire(promotion);
		
		when(qtyBasedPriceOverride.addItem(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(expected);
		Double result=instance.addItem(basketEntity, itemWireDTO);
		
		assertEquals(expected,result);
	}
	
	private ItemWireOutDTO newItemWire(PromotionWireOutDTO promotion) {
		ItemWireOutDTO itemWireDTO = new ItemWireOutDTO();
		ArrayList<PromotionWireOutDTO> promotions=new ArrayList<>();
		promotions.add(promotion);
		itemWireDTO.setPromotions(promotions);
		return itemWireDTO;
	}
	
}
