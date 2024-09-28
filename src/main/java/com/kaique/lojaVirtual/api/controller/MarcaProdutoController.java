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

import com.kaique.lojaVirtual.domain.dto.request.MarcaRequestDto;
import com.kaique.lojaVirtual.domain.dto.response.MarcaResponseDto;
import com.kaique.lojaVirtual.domain.services.MarcaProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/marcaProdutos")
public class MarcaProdutoController {

	@Autowired
	private MarcaProdutoService servives;

	@GetMapping("/{id}")
	public MarcaResponseDto buscaPorId(@PathVariable Long id) {
		return new MarcaResponseDto(servives.buscaPorId(id));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MarcaResponseDto salvaPessoaUser(@Valid @RequestBody MarcaRequestDto dto) {
		return new MarcaResponseDto(servives.Salva(dto));
	}

	@PutMapping("/{id}")
	public MarcaResponseDto atualizar(@Valid @RequestBody MarcaRequestDto dto, @PathVariable Long id) {
		return new MarcaResponseDto(servives.atualizar(dto, id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		servives.deletar(id);
	}
}
