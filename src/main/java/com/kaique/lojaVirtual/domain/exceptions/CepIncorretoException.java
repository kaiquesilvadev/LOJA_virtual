package com.kaique.lojaVirtual.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CepIncorretoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CepIncorretoException(String msg) {
		super(msg);
	}
}