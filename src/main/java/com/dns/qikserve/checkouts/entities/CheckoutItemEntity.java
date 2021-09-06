package com.dns.qikserve.checkouts.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutItemEntity implements Serializable {

	private static final long serialVersionUID = -839883184890865498L;

	private String id;

	private String name;

	private Double price;

	private Integer count;

}
