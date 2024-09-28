package com.kaique.lojaVirtual.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* Todo apagar quando criar classse advencer de comtroler*/
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class UsuarioNaoAutorisadoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsuarioNaoAutorisadoException(String msg) {
		super(msg);
	}
}
