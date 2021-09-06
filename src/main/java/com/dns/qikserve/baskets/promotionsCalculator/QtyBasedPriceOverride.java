package com.dns.qikserve.baskets.promotionsCalculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.QtyBasedPriceOverrideOutDTO;
import com.dns.qikserve.exceptions.UnexpectedCastException;

@Service
public class QtyBasedPriceOverride implements IPromotion<QtyBasedPriceOverrideOutDTO> {

	@Override
	public Double addItem(BasketEntity basketEntity, ItemWireOutDTO itemWireDTO, PromotionWireOutDTO promotion) {
		QtyBasedPriceOverrideOutDTO qtyBasedPriceOverrideOutDTO=tryGetClass(promotion);
		Integer requiredQTY = qtyBasedPriceOverrideOutDTO.getRequired_qty();
		Integer currentXItemsCount = basketEntity.getItemIDVSItemCount().getOrDefault(itemWireDTO.getId(), 0) + 1;
		if (currentXItemsCount % requiredQTY == 0) {
			Integer price = qtyBasedPriceOverrideOutDTO.getPrice();
			BigDecimal previousValue = new BigDecimal(String.valueOf(itemWireDTO.getPrice()))
					.multiply(new BigDecimal(String.valueOf(requiredQTY)));
			BigDecimal difference = previousValue.subtract(new BigDecimal(String.valueOf(price)));
			return difference.doubleValue();
		} else {
			return 0.0;
		}
	}

	public QtyBasedPriceOverrideOutDTO tryGetClass(PromotionWireOutDTO promotion) {
		try {
			return (QtyBasedPriceOverrideOutDTO) promotion;
		}catch (Exception e) {
			throw new UnexpectedCastException("Error trying to rerieve all the values of promotion  QtyBasedPriceOverride");
		}
	}



}
