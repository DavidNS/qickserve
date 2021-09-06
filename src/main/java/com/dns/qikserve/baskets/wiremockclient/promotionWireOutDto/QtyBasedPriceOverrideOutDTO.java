package com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto;

import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QtyBasedPriceOverrideOutDTO extends PromotionWireOutDTO{
	
	private Integer required_qty;
	
	private Integer price;
	
}
