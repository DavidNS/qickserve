package com.dns.qikserve.baskets.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemEntity implements Serializable{
	
	private static final long serialVersionUID = -2270937081366948209L;

	private String id;

	private String name;

	private Double price;

}
