package com.kaique.lojaVirtual.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.dto.request.PessoaPjDtoReq;
import com.kaique.lojaVirtual.domain.dto.response.PessoaPjResponse;
import com.kaique.lojaVirtual.domain.services.PessoaPjServives;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/PsJuridica")
public class PessoaJuridicaContrller {

	@Autowired
	private PessoaPjServives servives;

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaPjResponse salvaPessoaPj(@Valid @RequestBody PessoaPjDtoReq dto) {
		return new PessoaPjResponse(servives.salvaPessoaPj(dto));
	}
}
