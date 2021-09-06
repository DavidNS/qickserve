package com.dns.qikserve.baskets.outDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BasketOutDTO {
	
	private Integer basketID;

	private List<ItemOutDTO> items;
	
	private Double rawTotal;
	
	private Double totalPromos;
	
	private Double totalPayable; 
	
}
