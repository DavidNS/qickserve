package com.dns.qikserve.baskets.wiremockclient;

import com.dns.qikserve.baskets.PromotionWireType;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.BuyXGetYFreeOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.FlatPercentOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.QtyBasedPriceOverrideOutDTO;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type",visible = true)
@JsonSubTypes({ 
		@Type(value = BuyXGetYFreeOutDTO.class, name = "BUY_X_GET_Y_FREE"),
		@Type(value = FlatPercentOutDTO.class, name = "FLAT_PERCENT"),
		@Type(value = QtyBasedPriceOverrideOutDTO.class, name = "QTY_BASED_PRICE_OVERRIDE") })
public abstract class PromotionWireOutDTO {

	private String id;

	private PromotionWireType type;

}
