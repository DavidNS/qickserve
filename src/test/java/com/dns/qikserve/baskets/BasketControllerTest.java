package com.dns.qikserve.baskets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dns.qikserve.baskets.inDTO.ItemInDTO;
import com.dns.qikserve.baskets.outDTO.BasketOutDTO;
import com.dns.qikserve.baskets.outDTO.ItemOutDTO;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.WiremockClient;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.FlatPercentOutDTO;
import com.dns.qikserve.checkouts.CheckoutController;
import com.dns.qikserve.checkouts.dto.CheckoutDTO;

@ExtendWith(MockitoExtension.class)
class BasketControllerTest {
	
	@Mock
	private WiremockClient wiremockClient;

	@Mock
	private BasketService basketService;

	@Mock
	private CheckoutController checkoutController;
	
	@InjectMocks
	private BasketController instance;
	
	@Test
	void createBasket() {
		BasketOutDTO expected=new BasketOutDTO();
		when(instance.createBasket()).thenReturn(expected);
		BasketOutDTO actual=instance.createBasket();
		assertEquals(expected, actual);
	}
	

	@Test
	void createBasketNull() {
		BasketOutDTO basketOutDTO=instance.createBasket();
		assertNull(basketOutDTO);
	}
	

	@Test
	void addItemBasket() {
		ItemWireOutDTO itemWireDTO=new ItemWireOutDTO();
		itemWireDTO.setId("1");
		itemWireDTO.setName("name");
		itemWireDTO.setPrice(1.0);
		ArrayList<PromotionWireOutDTO> promotions=new ArrayList<>();
		promotions.add(new FlatPercentOutDTO());
		itemWireDTO.setPromotions(promotions);
		
		ItemInDTO itemInDTO=new ItemInDTO("1");
		
		BasketOutDTO result=instance.addItemToBasket(1, itemInDTO);
		assertNull(result);
		
	}

	@Test
	void checkoutBasketEmptyItems() {
		BasketOutDTO basketOutDTO=new BasketOutDTO();
		when(basketService.checkoutBasket(Mockito.anyInt())).thenReturn(basketOutDTO);
		CheckoutDTO result=instance.checkoutBasket(1);
		assertNull(result);
	}

	@Test
	void checkoutBasketWithItems() {
		ItemOutDTO item=new ItemOutDTO();
		ArrayList<ItemOutDTO> items=new ArrayList<>();
		items.add(item);
		BasketOutDTO basketOutDTO=new BasketOutDTO(1,items,10.0,1.0,9.0);
		
		when(basketService.checkoutBasket(Mockito.anyInt())).thenReturn(basketOutDTO);
		CheckoutDTO result=instance.checkoutBasket(1);
		assertNull(result);
	}
	
}
