package com.kaique.lojaVirtual.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.MarcaRequestDto;
import com.kaique.lojaVirtual.domain.entity.MarcaProduto;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
import com.kaique.lojaVirtual.domain.repositories.MarcaProdutoRepository;

@Service
public class MarcaProdutoService {

	@Autowired
	private MarcaProdutoRepository repository;
	
	
	@Transactional
	public MarcaProduto Salva(MarcaRequestDto Dto) {
		
		if(repository.buscaDescricao(Dto.getNomeDesc()).isPresent()) {
			throw new EntidadeExistenteException("Essa descrição de marca já está presente no banco de dados.");
		}
		
		return repository.save(convertdto(Dto));
	}
	
	private MarcaProduto convertdto(MarcaRequestDto Dto) {
		
		MarcaProduto marcaProduto = new MarcaProduto();
		marcaProduto.setNomeDesc(Dto.getNomeDesc());
		
		return marcaProduto;
	}
}
