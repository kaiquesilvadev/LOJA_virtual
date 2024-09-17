package com.kaique.lojaVirtual.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.PessoaPjDtoReq;
import com.kaique.lojaVirtual.domain.entity.Endereco;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
import com.kaique.lojaVirtual.domain.repositories.PessoaJuridicaRepository;

@Service
public class PessoaPjServives {

	@Autowired
	private PessoaJuridicaRepository repository;

	@Autowired
	private usuarioService usuarioService;
	
	@Autowired
	private EnderecoService enderecoService;

	@Transactional
	public PessoaJuridica salvaPessoaPj(PessoaPjDtoReq dto) {

		if (repository.existsByEmail(dto.getEmail()) == true)
			throw new EntidadeExistenteException("Email ja cadastrado no sistema.");

		if (repository.cnpjExistente(dto.getCnpj()).isPresent())
			throw new EntidadeExistenteException("Já existe CNPJ cadastrado com o número: " + dto.getCnpj());

		PessoaJuridica pessoa = repository.save(converteDto(dto));
		List<Endereco> enderecos = dto.getEndereco().stream().map(endereco ->  enderecoService.converteEndereco(endereco, pessoa , pessoa)).toList();
		usuarioService.criaUserPadrao(pessoa ,  "ROLE_ADMIN");

		pessoa.getEnderecos().addAll(enderecoService.salvaEnderecoList(enderecos));
		return pessoa;
	}


	private PessoaJuridica converteDto(PessoaPjDtoReq dtoReq) {

		PessoaJuridica pessoa = new PessoaJuridica();
		pessoa.setNome(dtoReq.getNome());
		pessoa.setEmail(dtoReq.getEmail());
		pessoa.setTelefone(dtoReq.getTelefone());
		pessoa.setCnpj(dtoReq.getCnpj());
		pessoa.setInscEstadual(dtoReq.getInscEstadual());
		pessoa.setInscMunicipal(dtoReq.getInscMunicipal());
		pessoa.setNomeFantasia(dtoReq.getNomeFantasia());
		pessoa.setRazaoSocial(dtoReq.getRazaoSocial());
		
		return pessoa;
	}
}
