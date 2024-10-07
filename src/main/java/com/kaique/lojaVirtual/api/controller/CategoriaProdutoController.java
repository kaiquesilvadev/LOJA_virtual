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

import com.kaique.lojaVirtual.domain.dto.request.CategoriaRequestDto;
import com.kaique.lojaVirtual.domain.dto.response.CategoriaResponseDto;
import com.kaique.lojaVirtual.domain.services.CategoriaProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/CategoriaProdutos")
public class CategoriaProdutoController {

	@Autowired
	private CategoriaProdutoService servives;

	@GetMapping("/{id}")
	public CategoriaResponseDto buscaPorId(@PathVariable Long id) {
		return new CategoriaResponseDto(servives.buscaPorId(id));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CategoriaResponseDto salvaPessoaUser(@Valid @RequestBody CategoriaRequestDto dto) {
		return new CategoriaResponseDto(servives.Salva(dto));
	}

	@PutMapping("/{id}")
	public CategoriaResponseDto atualizar(@Valid @RequestBody CategoriaRequestDto dto, @PathVariable Long id) {
		return new CategoriaResponseDto(servives.atualizar(dto, id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		servives.deletar(id);
	}
}
