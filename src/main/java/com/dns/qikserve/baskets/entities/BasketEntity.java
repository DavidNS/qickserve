package com.dns.qikserve.baskets.entities;

import java.util.HashMap;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyEnumerated;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BasketEntity {

	@Id
	@GeneratedValue
	private Integer basktetID;
	
	private Double rawTotal=0.0;
	
	private Double totalPromos=0.0;
	
	private Double totalPayable=0.0;
	
	@MapKeyEnumerated
	@Lob
	private HashMap<String, BasketItemEntity> itemIDVSItemDescription=new HashMap<>();
	
	@MapKeyEnumerated
	private HashMap<String, Integer> itemIDVSItemCount=new HashMap<>();
	
}
