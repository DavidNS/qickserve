package com.dns.qikserve.baskets.wiremockclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.dns.qikserve.exceptions.BadGatewayException;

@ExtendWith(MockitoExtension.class)
class WiremockClientTest {

	@Mock
	WiremockClientConfiguration wiremockCLientConfiguration;

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	WiremockClient instance;

	@Test
	void constructor() {
		assertNotNull(instance);
	}

	@Test
	void getItemByIdGatewayError() {
		when(restTemplate.getForEntity(Mockito.any(), Mockito.any())).thenThrow(new RestClientException("message"));
		assertThrows(BadGatewayException.class, () -> {
			instance.getItemById(null);
		});
	}

	@Test
	void getItemByIdMockedRestTemplate() {
		ItemWireOutDTO expected = new ItemWireOutDTO();

		when(restTemplate.getForEntity("null/products/1", ItemWireOutDTO.class))
				.thenReturn(ResponseEntity.of(Optional.of(expected)));
		ItemWireOutDTO result = instance.getItemById("1");
		assertEquals(expected, result);
	}

}
