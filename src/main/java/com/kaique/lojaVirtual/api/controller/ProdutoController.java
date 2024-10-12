package com.kaique.lojaVirtual.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.dto.request.ProdutoDtoRequest;
import com.kaique.lojaVirtual.domain.dto.response.ProdutoResponseDto;
import com.kaique.lojaVirtual.domain.entity.Produto;
import com.kaique.lojaVirtual.domain.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping("/{id}")
	public ProdutoResponseDto buscaPorId(@PathVariable Long id) {
		return new ProdutoResponseDto(service.buscaPorId(id));
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ProdutoResponseDto Salva(@Valid @RequestBody ProdutoDtoRequest dto) {
		return new ProdutoResponseDto(service.Salva(dto));
	}

	@PutMapping("/{id}")
	public ProdutoResponseDto atualizar(@Valid @RequestBody ProdutoDtoRequest dto, @PathVariable Long id) {
		return new ProdutoResponseDto(service.atualizar(dto, id));
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
