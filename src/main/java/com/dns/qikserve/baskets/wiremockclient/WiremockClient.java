package com.dns.qikserve.baskets.wiremockclient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dns.qikserve.exceptions.BadGatewayException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WiremockClient {
	
	private static final String PRODUCTS = "/products/";
	
	private final WiremockClientConfiguration wiremockCLientConfiguration;
	
	private final RestTemplate restTemplate;
	
	public ItemWireOutDTO getItemById(String productID) throws BadGatewayException{
		try {
			ResponseEntity<ItemWireOutDTO> itemWireDTO=restTemplate.getForEntity(wiremockCLientConfiguration.getEndpoint()+PRODUCTS+productID, ItemWireOutDTO.class);
			return itemWireDTO.getBody();
		
		}catch (Exception e) {
			throw new BadGatewayException("Error trying to establish communication with wiremock server");
		}
	}
	

}
