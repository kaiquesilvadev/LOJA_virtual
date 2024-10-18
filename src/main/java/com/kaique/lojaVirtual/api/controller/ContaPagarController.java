package com.kaique.lojaVirtual.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.dto.request.ContaPagarRequestDto;
import com.kaique.lojaVirtual.domain.dto.response.ContaPagarResponseDto;
import com.kaique.lojaVirtual.domain.services.ContaPagarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/contasPagar")
public class ContaPagarController {
	
	@Autowired
	private ContaPagarService servives;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContaPagarResponseDto salvaPessoaUser(@Valid @RequestBody ContaPagarRequestDto dto) {
		return new ContaPagarResponseDto(servives.salva(dto));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		servives.deletar(id);
	}
}
