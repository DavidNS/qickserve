package com.dns.qikserve.baskets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.dns.qikserve.baskets.entities.BasketEntity;
import com.dns.qikserve.baskets.entities.BasketItemEntity;
import com.dns.qikserve.baskets.outDTO.BasketOutDTO;
import com.dns.qikserve.baskets.outDTO.ItemOutDTO;
import com.dns.qikserve.baskets.promotionsCalculator.PromotionCalculator;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.exceptions.NoSuchElementFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasketService {

	private final BasketRepository basketRepository;

	private final PromotionCalculator promotionCalculator;

	public BasketOutDTO createBasket() {
		BasketEntity basketEntity = basketRepository.save(new BasketEntity());
		return basketEntityToBasketOutDTO(basketEntity);
	}

	public BasketOutDTO addItem(Integer basktetID, ItemWireOutDTO itemWireDTO) throws NoSuchElementFoundException {
		BasketEntity basketEntity = basketRepository.findById(basktetID)
				.orElseThrow(() -> new NoSuchElementFoundException("Not found basked with id: " + basktetID));
		Double promotionResult = promotionCalculator.addItem(basketEntity, itemWireDTO);
		updateBasketEntity(basketEntity, itemWireDTO, promotionResult);
		basketEntity=basketRepository.save(basketEntity);
		return basketEntityToBasketOutDTO(basketEntity);
	}

	public BasketOutDTO checkoutBasket(Integer basktetID) throws NoSuchElementFoundException {
		BasketEntity basketEntity = basketRepository.findById(basktetID)
				.orElseThrow(() -> new NoSuchElementFoundException("Not found basked with id: " + basktetID));
		basketRepository.delete(basketEntity);
		return basketEntityToBasketOutDTO(basketEntity);
	}

	private void updateBasketEntity(BasketEntity basketEntity, ItemWireOutDTO itemWireDTO, Double promotionResult) {
		BigDecimal rawTotal = new BigDecimal(String.valueOf(basketEntity.getRawTotal()))
				.add(new BigDecimal(String.valueOf(itemWireDTO.getPrice())));
		BigDecimal totalPromos = new BigDecimal(String.valueOf(basketEntity.getTotalPromos()))
				.add(new BigDecimal(String.valueOf(promotionResult)));
		BigDecimal totalPayable = rawTotal.subtract(totalPromos);

		basketEntity.setRawTotal(rawTotal.doubleValue());
		basketEntity.setTotalPromos(totalPromos.doubleValue());
		basketEntity.setTotalPayable(totalPayable.doubleValue());
		Integer itemCount = basketEntity.getItemIDVSItemCount().getOrDefault(itemWireDTO.getId(), 0);
		basketEntity.getItemIDVSItemCount().put(itemWireDTO.getId(), itemCount + 1);
		basketEntity.getItemIDVSItemDescription().put(itemWireDTO.getId(), itemWireDTOToItemEntity(itemWireDTO));
	}

	private BasketItemEntity itemWireDTOToItemEntity(ItemWireOutDTO itemWireDTO) {
		return new BasketItemEntity(itemWireDTO.getId(), itemWireDTO.getName(), itemWireDTO.getPrice());
	}

	private BasketOutDTO basketEntityToBasketOutDTO(BasketEntity basketEntity) {
		ArrayList<ItemOutDTO> items = new ArrayList<>();
		HashMap<String, Integer> itemIDVSCount = basketEntity.getItemIDVSItemCount();
		HashMap<String, BasketItemEntity> itemIDVSItemDescription = basketEntity.getItemIDVSItemDescription();
		if (itemIDVSItemDescription != null && itemIDVSCount != null) {
			for (Entry<String, BasketItemEntity> itemIDVSItemDescriptionSet : itemIDVSItemDescription.entrySet()) {
				String itemID = itemIDVSItemDescriptionSet.getKey();
				BasketItemEntity itemEntity = itemIDVSItemDescriptionSet.getValue();
				items.add(
						new ItemOutDTO(itemID, itemEntity.getName(), itemEntity.getPrice(), itemIDVSCount.get(itemID)));
			}
		}
		return new BasketOutDTO(basketEntity.getBasktetID(), items, basketEntity.getRawTotal(),
				basketEntity.getTotalPromos(), basketEntity.getTotalPayable());
	}

}
