package com.dns.qikserve.baskets.promotionsCalculator;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.PromotionWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.promotionWireOutDto.FlatPercentOutDTO;
import com.dns.qikserve.exceptions.UnexpectedCastException;

@Service
public class FlatPercent implements IPromotion<FlatPercentOutDTO> {

	private static final String PER_CENT = "100";

	@Override
	public Double addItem(BasketEntity basketEntity, ItemWireOutDTO itemWireDTO, PromotionWireOutDTO promotion) {
		FlatPercentOutDTO flatPercentOutDTO=tryGetClass(promotion);
		Integer amount = flatPercentOutDTO.getAmount();
		BigDecimal price=new BigDecimal(String.valueOf(itemWireDTO.getPrice()));
		return price.multiply(new BigDecimal(String.valueOf(amount))).divide(new BigDecimal(PER_CENT)).doubleValue();
	}
	
	@Override
	public FlatPercentOutDTO tryGetClass(PromotionWireOutDTO promotion) {
		try {
			return (FlatPercentOutDTO) promotion;
		}catch (Exception e) {
			throw new UnexpectedCastException("Error trying to rerieve all the values of promotion  FlatPercent");
		}
	}

}
