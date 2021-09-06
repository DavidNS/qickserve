package com.dns.qikserve.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BadGatewayExceptionTest {

	@Test
	void constructor() {
		BadGatewayException instance=new BadGatewayException(null);
		assertNotNull(instance);
	}

	@Test
	void message() {
		String message="message";
		String expected="502 BAD_GATEWAY \"message\"";
		BadGatewayException instance=new BadGatewayException(message);
		String result=instance.getLocalizedMessage();
		assertEquals(expected, result);
	}
	
}
