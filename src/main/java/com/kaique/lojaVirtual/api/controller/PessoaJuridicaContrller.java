package com.kaique.lojaVirtual.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/buscaPorNome/{nome}")
	public List<PessoaPjResponse> buscaPorNome(@PathVariable String nome) {
		return new PessoaPjResponse().converteListEntitry(servives.buscaPorNome(nome));
	}

	@GetMapping("/buscaPorCnpj/{cnpj}")
	public PessoaPjResponse buscaPorCnpj(@PathVariable String cnpj) {
		return new PessoaPjResponse(servives.buscaPorCnpj(cnpj));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaPjResponse salvaPessoaPj(@Valid @RequestBody PessoaPjDtoReq dto) {
		return new PessoaPjResponse(servives.salvaPessoaPj(dto));
	}
}
