package com.dns.qikserve.checkouts;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dns.qikserve.checkouts.dto.CheckoutDTO;
import com.dns.qikserve.checkouts.dto.ItemCheckoutDTO;
import com.dns.qikserve.checkouts.entities.CheckoutEntity;
import com.dns.qikserve.checkouts.entities.CheckoutItemEntity;
import com.dns.qikserve.exceptions.NoSuchElementFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckoutService {

	private final CheckoutRepository checkoutRepository;

	public CheckoutDTO getById(@PathVariable Integer id) throws NoSuchElementFoundException {
		CheckoutEntity checkoutEntity = checkoutRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementFoundException("Not found checkout with id: " + id));
		return checkoutEntityToCheckoutOutDTO(checkoutEntity);
	}

	public CheckoutDTO addCheckOut(CheckoutDTO checkoutDTO) {
		CheckoutEntity checkoutEntity = checkoutDTOToCheckoutEntity(checkoutDTO);
		checkoutEntity = checkoutRepository.save(checkoutEntity);
		return checkoutEntityToCheckoutOutDTO(checkoutEntity);
	}

	private CheckoutDTO checkoutEntityToCheckoutOutDTO(CheckoutEntity basketOutDTO) {
		ArrayList<ItemCheckoutDTO> items = new ArrayList<>();
		if (basketOutDTO.getItems() != null) {
			for (CheckoutItemEntity itemOutDtoBask : basketOutDTO.getItems()) {
				items.add(new ItemCheckoutDTO(itemOutDtoBask.getId(), itemOutDtoBask.getName(),
						itemOutDtoBask.getPrice(), itemOutDtoBask.getCount()));
			}
		}
		return new CheckoutDTO(basketOutDTO.getCheckoutID(), items, basketOutDTO.getRawTotal(),
				basketOutDTO.getTotalPromos(), basketOutDTO.getTotalPayable());
	}

	private CheckoutEntity checkoutDTOToCheckoutEntity(CheckoutDTO checkoutDTO) {
		ArrayList<CheckoutItemEntity> items = new ArrayList<>();
		if(checkoutDTO.getItems()!=null) {
			for (ItemCheckoutDTO itemDTO : checkoutDTO.getItems()) {
				items.add(
						new CheckoutItemEntity(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getCount()));
			}
		}
		return new CheckoutEntity(checkoutDTO.getCheckoutID(), items, checkoutDTO.getRawTotal(),
				checkoutDTO.getTotalPromos(), checkoutDTO.getTotalPayable());
	}

}
