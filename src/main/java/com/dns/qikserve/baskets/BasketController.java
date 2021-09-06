package com.dns.qikserve.baskets;

import java.util.ArrayList;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dns.qikserve.baskets.inDTO.ItemInDTO;
import com.dns.qikserve.baskets.outDTO.BasketOutDTO;
import com.dns.qikserve.baskets.outDTO.ItemOutDTO;
import com.dns.qikserve.baskets.wiremockclient.ItemWireOutDTO;
import com.dns.qikserve.baskets.wiremockclient.WiremockClient;
import com.dns.qikserve.checkouts.CheckoutController;
import com.dns.qikserve.checkouts.dto.CheckoutDTO;
import com.dns.qikserve.checkouts.dto.ItemCheckoutDTO;
import com.dns.qikserve.exceptions.BadGatewayException;
import com.dns.qikserve.exceptions.NoSuchElementFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/baskets")
public class BasketController {

	private final WiremockClient wiremockClient;

	private final BasketService basketService;

	private final CheckoutController checkoutController;

	@PostMapping
	public BasketOutDTO createBasket() {
		return basketService.createBasket();
	}

	@PostMapping(path = "/{basketID}/items")
	public BasketOutDTO addItemToBasket(@PathVariable Integer basketID, @Validated @RequestBody ItemInDTO itemInDTO)
			throws NoSuchElementFoundException, BadGatewayException {
		ItemWireOutDTO itemWireDTO = wiremockClient.getItemById(itemInDTO.getItemID());
		return basketService.addItem(basketID, itemWireDTO);
	}

	@GetMapping(path = "/{basketID}/checkout")
	public CheckoutDTO checkoutBasket(@PathVariable Integer basketID) throws NoSuchElementFoundException {
		BasketOutDTO basketOutDTO = basketService.checkoutBasket(basketID);
		CheckoutDTO checkoutDTO = basketOutDTOToCheckoutDTO(basketOutDTO);
		return checkoutController.addCheckOut(checkoutDTO);
	}

	private CheckoutDTO basketOutDTOToCheckoutDTO(BasketOutDTO basketOutDTO) {
		ArrayList<ItemCheckoutDTO> items = new ArrayList<>();
		if (basketOutDTO.getItems() != null) {
			for (ItemOutDTO itemOutDTO : basketOutDTO.getItems()) {
				items.add(new ItemCheckoutDTO(itemOutDTO.getId(), itemOutDTO.getName(), itemOutDTO.getPrice(),
						itemOutDTO.getCount()));
			}
		}
		return new CheckoutDTO(basketOutDTO.getBasketID(), items, basketOutDTO.getRawTotal(),
				basketOutDTO.getTotalPromos(), basketOutDTO.getTotalPayable());
	}

}
