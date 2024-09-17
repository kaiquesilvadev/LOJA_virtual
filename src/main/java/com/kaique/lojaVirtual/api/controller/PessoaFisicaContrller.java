package com.kaique.lojaVirtual.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.dto.request.PessoaFsUserDtoReq;
import com.kaique.lojaVirtual.domain.dto.response.PessoaFisicaDtoResponse;
import com.kaique.lojaVirtual.domain.services.PessoaFsUserServives;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/PessoaFisicas")
public class PessoaFisicaContrller {

	@Autowired
	private PessoaFsUserServives servives;

	@PostMapping("/salvaUser")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaFisicaDtoResponse salvaPessoaUser(@Valid @RequestBody PessoaFsUserDtoReq dto) {
		return new PessoaFisicaDtoResponse(servives.salvaPessoaUser(dto));
	}
}
