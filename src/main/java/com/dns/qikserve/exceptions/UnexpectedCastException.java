package com.dns.qikserve.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnexpectedCastException extends ResponseStatusException {
	
	private static final long serialVersionUID = 6759504218378495352L;

	public UnexpectedCastException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}
}