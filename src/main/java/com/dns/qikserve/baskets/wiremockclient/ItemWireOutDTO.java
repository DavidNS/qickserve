package com.dns.qikserve.baskets.wiremockclient;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemWireOutDTO {

	private String id;

	private String name;

	private Double price;

	private List<PromotionWireOutDTO> promotions=new ArrayList<>();

}
