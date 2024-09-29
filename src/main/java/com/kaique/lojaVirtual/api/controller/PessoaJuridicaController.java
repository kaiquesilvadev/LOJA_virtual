package com.kaique.lojaVirtual.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaique.lojaVirtual.domain.dto.request.EnderecoPSFisicaRequestDto;
import com.kaique.lojaVirtual.domain.dto.request.EnderecoRequestDto;
import com.kaique.lojaVirtual.domain.dto.request.PessoaPjDtoReq;
import com.kaique.lojaVirtual.domain.dto.response.EnderecoRespCustoDto;
import com.kaique.lojaVirtual.domain.dto.response.EnderecoResponseDto;
import com.kaique.lojaVirtual.domain.dto.response.PessoaPjResponse;
import com.kaique.lojaVirtual.domain.services.PessoaEnderecoService;
import com.kaique.lojaVirtual.domain.services.PessoaPjServives;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/PsJuridica")
public class PessoaJuridicaController {
	
	@Autowired
	private PessoaEnderecoService psEnderecoService;

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
	
	@GetMapping("/listaEndereco")
	public List<EnderecoRespCustoDto> listaEnderecoProprios() {
		return EnderecoRespCustoDto.listaEnderecoProprios(psEnderecoService.ListaEnderecoPs());		
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaPjResponse salvaPessoaPj(@Valid @RequestBody PessoaPjDtoReq dto) {
		return new PessoaPjResponse(servives.salvaPessoaPj(dto));
	}
	
	@PutMapping("{idPessoa}/atualizaEndereco/{idEnderco}")
	public EnderecoResponseDto atualizaEndereco(@Valid @RequestBody EnderecoRequestDto dto, @PathVariable Long idEnderco , @PathVariable Long idPessoa) {
		return new EnderecoResponseDto(psEnderecoService.AtualizaEnderecoPSJuridica(dto, idEnderco , idPessoa));
	}
}
