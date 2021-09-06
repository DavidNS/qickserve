package com.dns.qikserve.checkouts.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutEntity {

	@Id
	private Integer checkoutID;

	@ElementCollection
	private List<CheckoutItemEntity> items;

	private Double rawTotal = 0.0;

	private Double totalPromos = 0.0;

	private Double totalPayable = 0.0;

}
