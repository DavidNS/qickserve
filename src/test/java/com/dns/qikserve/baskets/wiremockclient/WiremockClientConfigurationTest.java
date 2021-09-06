package com.dns.qikserve.baskets.wiremockclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class WiremockClientConfigurationTest {

	@Test
	void constructor() {
		WiremockClientConfiguration instance=new WiremockClientConfiguration();
		assertNotNull(instance);
	}
	
	@Test
	void getEndpoint() {
		WiremockClientConfiguration instance=new WiremockClientConfiguration();
		assertNull(instance.getEndpoint());
	}

	@Test
	void setEndpoint() {
		String expected="A";
		WiremockClientConfiguration instance=new WiremockClientConfiguration();
		instance.setEndpoint(expected);
		assertEquals(expected, instance.getEndpoint());
	}

	
}
