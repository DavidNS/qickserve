package com.dns.qikserve.baskets.promotionsCalculator;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.dns.qikserve.baskets.PromotionWireType;
import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;

@Service
public class PromotionCalculator {

	private HashMap<PromotionWireType, IPromotion<?>> promotionTypeVsService = new HashMap<>();

	public PromotionCalculator(ApplicationContext context) {
		promotionTypeVsService.put(PromotionWireType.BUY_X_GET_Y_FREE, context.getBean(BuyXGetYFree.class));
		promotionTypeVsService.put(PromotionWireType.FLAT_PERCENT, context.getBean(FlatPercent.class));
		promotionTypeVsService.put(PromotionWireType.QTY_BASED_PRICE_OVERRIDE, context.getBean(QtyBasedPriceOverride.class));
	}

	public Double addItem(BasketEntity basketEntity, ItemWireOutDTO itemWireDTO) {
		Double totalAmmount = 0.0;
		List<PromotionWireOutDTO> promotions = itemWireDTO.getPromotions();
		if (promotions != null && promotions.size() > 0) {
			PromotionWireOutDTO promotion = promotions.get(0);
			IPromotion<?> promotionService = promotionTypeVsService.get(promotion.getType());
			totalAmmount = promotionService.addItem(basketEntity, itemWireDTO, promotion);
		}
		return totalAmmount;
	}

}
