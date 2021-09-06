package com.dns.qikserve.baskets.promotionsCalculator;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;

public interface IPromotion<T extends PromotionWireOutDTO> {

	public Double addItem(BasketEntity basketEntity, ItemWireOutDTO itemWireDTO, PromotionWireOutDTO promotion );
	
	
	public T tryGetClass(PromotionWireOutDTO promotion);
	
}
