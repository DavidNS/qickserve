package com.dns.qikserve.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchElementFoundException extends ResponseStatusException {

	private static final long serialVersionUID = -9214578157482269264L;

	public NoSuchElementFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
}
