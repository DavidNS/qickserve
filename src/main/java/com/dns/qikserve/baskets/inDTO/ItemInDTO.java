package com.dns.qikserve.baskets.inDTO;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemInDTO {

	@NotBlank(message = "itemID is mandatory")
	private String itemID;
}
