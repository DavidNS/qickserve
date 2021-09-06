package com.dns.qikserve.checkouts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCheckoutDTO {

	private String id;
	
	private String name;
	
	private Double price;
	
	private Integer count;
	
}
