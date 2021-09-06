package com.dns.qikserve.checkouts;

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

import com.dns.qikserve.checkouts.dto.CheckoutDTO;
import com.dns.qikserve.checkouts.entities.CheckoutEntity;
import com.dns.qikserve.exceptions.NoSuchElementFoundException;

@ExtendWith(MockitoExtension.class)
class CheckoutServiceTest {

	@Mock
	CheckoutRepository checkoutRepository;

	@InjectMocks
	CheckoutService instance;

	@Test
	void consturctor() {
		assertNotNull(instance);
	}

	@Test
	void getByIdNoSuchFound() {
		assertThrows(NoSuchElementFoundException.class, () -> {
			instance.getById(1);
		});
	}

	@Test
	void getByIdMockedRepo() {
		CheckoutEntity checkoutEntity = new CheckoutEntity();
		when(checkoutRepository.findById(Mockito.any())).thenReturn(Optional.of(checkoutEntity));
		assertNotNull(instance.getById(null));

	}

	@Test
	void addCheckOutNullValuesNullPointer() {
		assertThrows(NullPointerException.class, () -> {
			instance.addCheckOut(null);
		});
	}

	@Test
	void addCheckOutWithValuesNullPointer() {
		assertThrows(NullPointerException.class, () -> {
			instance.addCheckOut(new CheckoutDTO());
		});
	}

	@Test
	void addCheckOutWithValuesRepoMocked() {
		CheckoutEntity checkoutEntity = new CheckoutEntity();
		when(checkoutRepository.save(Mockito.any())).thenReturn(checkoutEntity);
		assertNotNull(instance.addCheckOut(new CheckoutDTO()));
	}
}
