package com.dns.qikserve.checkouts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dns.qikserve.checkouts.dto.CheckoutDTO;
import com.dns.qikserve.exceptions.NoSuchElementFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/checkouts")
public class CheckoutController {

	private final CheckoutService checkoutService;

	@GetMapping(path = "/{id}")
	public CheckoutDTO getById(@PathVariable Integer id) throws NoSuchElementFoundException {
		return checkoutService.getById(id);
	}

	public CheckoutDTO addCheckOut(@RequestBody CheckoutDTO checkoutDTO) {
		return checkoutService.addCheckOut(checkoutDTO);
	}
}
