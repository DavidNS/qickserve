package com.dns.qikserve.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class NoSuchElementFoundExceptionTest {

	@Test
	void constructor() {
		NoSuchElementFoundException instance=new NoSuchElementFoundException(null);
		assertNotNull(instance);
	}

	@Test
	void message() {
		String message="message";
		String expected="404 NOT_FOUND \"message\"";
		NoSuchElementFoundException instance=new NoSuchElementFoundException(message);
		String result=instance.getLocalizedMessage();
		assertEquals(expected, result);
	}

}
