package com.dns.qikserve.checkouts;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CheckoutControllerTest {

	@Mock
	CheckoutService checkoutService;
	
	@InjectMocks
	CheckoutController instance;

	@Test
	void constructor() {
		assertNotNull(instance);
	}

	@Test
	void getById() {
		assertNull(instance.getById(null));
	}
	
	@Test
	void addCheckOut() {
		assertNull(instance.addCheckOut(null));
	}
}
