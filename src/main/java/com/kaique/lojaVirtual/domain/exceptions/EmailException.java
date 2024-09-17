package com.kaique.lojaVirtual.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmailException(String msg) {
		super(msg);
	}
}