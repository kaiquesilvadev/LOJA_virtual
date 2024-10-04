package com.kaique.lojaVirtual.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.ProdutoDtoRequest;
import com.kaique.lojaVirtual.domain.entity.ImagemProduto;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;
import com.kaique.lojaVirtual.domain.entity.Produto;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private ImplementacaoUserDetailsServices detailsServices;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Produto buscaPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ID de código '" + id + "' não encontrado ."));
	}

	@Transactional
	public Produto Salva(ProdutoDtoRequest dto) {
		return null;
	}

	@Transactional
	public Produto atualizar(ProdutoDtoRequest dto, Long id) {
		return null;
	}

	@Transactional
	public void deletar(Long id) {
	}

	private Produto convertdto(ProdutoDtoRequest dto , Produto produto , PessoaJuridica pessoaJuridica) {
		
		List<ImagemProduto> imagemProdutos = new ArrayList<>();

		produto.setTipoUnidade(dto.getTipoUnidade());
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPeso(dto.getPeso());
		produto.setLargura(dto.getLargura());
		produto.setAutura(dto.getAutura());
		produto.setProfundidade(dto.getProfundidade());
		produto.setValorVenda(dto.getValorVenda());
		produto.setQtdEstoque(dto.getQtdEstoque());
		produto.setQtdeAletaEstoque(dto.getQtdeAletaEstoque());
		produto.setAlertaQtdEstoque(dto.getAlertaQtdEstoque());
		//produto.setMarcaProduto(dto.getMarcaProduto());
		produto.setEmpresa(pessoaJuridica);
		//produto.getCategoriaProduto("");
		
		
		for (int img = 0 ; img < dto.getImagemProdutos().size() ; img++) {
		}

		return produto;
	}
}
