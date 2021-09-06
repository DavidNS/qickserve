package com.dns.qikserve.baskets;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.outDTO.BasketOutDTO;
import com.dns.qikserve.baskets.promotionsCalculator.PromotionCalculator;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.exceptions.NoSuchElementFoundException;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

	@Mock
	private BasketRepository basketRepository;

	@Mock
	private PromotionCalculator promotionCalculator;

	@InjectMocks
	private BasketService instance;

	@Test
	void createBasket() {
		BasketEntity entity = new BasketEntity();
		entity.setBasktetID(1);
		when(basketRepository.save(Mockito.any(BasketEntity.class))).thenReturn(entity);
		BasketOutDTO basketOutDTO = instance.createBasket();
		assertNotNull(basketOutDTO);
	}

	@Test()
	void addItemNullValues() {
		assertThrows(NoSuchElementFoundException.class, () -> {
			instance.addItem(null, null);
		});
	}

	@Test()
	void addItemWithValues() {
		assertThrows(NoSuchElementFoundException.class, () -> {
			instance.addItem(1, new ItemWireOutDTO());
		});
	}

	@Test()
	void addItemNullValuesRepositoryMocked() {
		when(basketRepository.findById(Mockito.any())).thenReturn(Optional.of(new BasketEntity()));
		assertThrows(NullPointerException.class, () -> {
			instance.addItem(null, null);
		});
	}

	@Test()
	void addItemWithValuesRepositoryMocked() {
		BasketEntity find = new BasketEntity();
		BasketEntity save = new BasketEntity();

		when(basketRepository.findById(Mockito.any())).thenReturn(Optional.of(find));
		when(basketRepository.save(Mockito.any())).thenReturn(save);

		ItemWireOutDTO itemWireDTO = new ItemWireOutDTO();
		itemWireDTO.setPrice(10.0);

		BasketOutDTO result = instance.addItem(1, itemWireDTO);
		assertNotNull(result);
	}

	@Test
	void checkoutBasketNullValues() {
		assertThrows(NoSuchElementFoundException.class, () -> {
			instance.checkoutBasket(null);
		});
	}

	@Test
	void checkoutBasketWithValues() {
		assertThrows(NoSuchElementFoundException.class, () -> {
			instance.checkoutBasket(1);
		});
	}

	@Test
	void checkoutBasketNullValuesRepositoryMocked() {
		BasketEntity find = new BasketEntity();
		when(basketRepository.findById(Mockito.any())).thenReturn(Optional.of(find));
		BasketOutDTO exected = instance.checkoutBasket(null);
		assertNotNull(exected);
	}
}
