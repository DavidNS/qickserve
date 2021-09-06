package com.dns.qikserve.baskets.promotionsCalculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.BuyXGetYFreeOutDTO;
import com.dns.qikserve.exceptions.UnexpectedCastException;

@Service
public class BuyXGetYFree implements IPromotion<BuyXGetYFreeOutDTO> {

	@Override
	public Double addItem(BasketEntity basketEntity, ItemWireOutDTO itemWireDTO, PromotionWireOutDTO promotion) {
		BuyXGetYFreeOutDTO buyXGetYFreeOutDTO=tryGetClass(promotion);
		Integer requiredQTY = buyXGetYFreeOutDTO.getRequired_qty();
		Integer currentXItemsCount = basketEntity.getItemIDVSItemCount().getOrDefault(itemWireDTO.getId(), 0) + 1;
		if (currentXItemsCount % requiredQTY == 0) {
			BigDecimal price=new BigDecimal(String.valueOf(itemWireDTO.getPrice()));
			Integer freeQTY= buyXGetYFreeOutDTO.getFree_qty();
			BigDecimal freeQTYBD =new  BigDecimal(String.valueOf(freeQTY));
			return  price.multiply(freeQTYBD).doubleValue();
		} else {
			return 0.0;
		}
	}

	@Override
	public BuyXGetYFreeOutDTO tryGetClass(PromotionWireOutDTO promotion) {
		try {
			return (BuyXGetYFreeOutDTO) promotion;
		}catch (Exception e) {
			throw new UnexpectedCastException("Error trying to rerieve all the values of promotion  QtyBasedPriceOverride");
		}
	}

}
