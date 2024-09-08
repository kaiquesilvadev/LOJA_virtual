package com.kaique.lojaVirtual.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.PessoaPjDtoReq;
import com.kaique.lojaVirtual.domain.entity.Pessoa;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
import com.kaique.lojaVirtual.domain.repositories.PessoaRepository;

@Service
public class PessoaServives {

	@Autowired
	private PessoaRepository repository;
	
	@Transactional
	public Pessoa salvaPessoaPj(PessoaPjDtoReq dto) {
		
		if(repository.existsByEmail(dto.getEmail()) == true)
			throw new EntidadeExistenteException("Email ja cadastrado no sistema.") ;
		
		if(repository.cnpjExistente(dto.getCnpj()).isPresent())
			throw new EntidadeExistenteException("Já existe CNPJ cadastrado com o número: " + dto.getCnpj()) ;
		
		
		return repository.save(null);
	}
	
	
}
