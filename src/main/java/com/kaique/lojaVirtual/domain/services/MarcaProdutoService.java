package com.kaique.lojaVirtual.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.MarcaRequestDto;
import com.kaique.lojaVirtual.domain.entity.MarcaProduto;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeEmUsoException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.repositories.MarcaProdutoRepository;

@Service
public class MarcaProdutoService {

	@Autowired
	private MarcaProdutoRepository repository;

	@Transactional(propagation = Propagation.SUPPORTS)
	public MarcaProduto buscaPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ID de marca com código '" + id + "' não encontrado ."));
	}

	@Transactional
	public MarcaProduto Salva(MarcaRequestDto Dto) {

		if (repository.buscaDescricao(Dto.getNomeDesc()).isPresent()) {
			throw new EntidadeExistenteException("Essa descrição de marca já está presente no banco de dados.");
		}

		return repository.save(convertdto(Dto, new MarcaProduto()));
	}

	@Transactional
	public MarcaProduto atualizar(MarcaRequestDto Dto, Long id) {

		MarcaProduto marcaProduto = buscaPorId(id);

		if (repository.buscaDescricao(Dto.getNomeDesc()).isPresent()) {
			throw new EntidadeExistenteException("Essa descrição de marca já está presente no banco de dados.");
		}

		return repository.save(convertdto(Dto, marcaProduto));
	}

	@Transactional
	public void deletar(Long id) {

		try {
			buscaPorId(id);
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		}

	}

	private MarcaProduto convertdto(MarcaRequestDto Dto, MarcaProduto marcaProduto) {

		marcaProduto.setNomeDesc(Dto.getNomeDesc());

		return marcaProduto;
	}
}
