package com.dns.qikserve.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadGatewayException extends ResponseStatusException {
	
	
	private static final long serialVersionUID = 1745761215188358233L;

	public BadGatewayException(String message) {
		super(HttpStatus.BAD_GATEWAY, message);
	}
}
