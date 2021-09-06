package com.dns.qikserve.checkouts.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDTO {
	
	private Integer checkoutID;

	private List<ItemCheckoutDTO> items;
	
	private Double rawTotal;
	
	private Double totalPromos;

	private Double totalPayable; 
}
