package com.kaique.lojaVirtual.domain.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.request.ProdutoDtoRequest;
import com.kaique.lojaVirtual.domain.entity.ImagemProduto;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;
import com.kaique.lojaVirtual.domain.entity.Produto;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeEmUsoException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.exceptions.UsuarioNaoAutorisadoException;
import com.kaique.lojaVirtual.domain.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ImplementacaoUserDetailsServices detailsServices;

	@Autowired
	private MarcaProdutoService marcaProdutoService;

	@Autowired
	private CategoriaProdutoService categoriaProdutoService;

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

	/*
	 * TODO : so quem pode deletar um produto é o proprio admim da empresa ou alquem
	 * devantado como admim para gerenciar
	 */
	@Transactional
	public void deletar(Long id) {
		Usuario usuario = detailsServices.authenticated();
		Produto produto = buscaPorId(id);

		Optional<Usuario> resultConsultaAcesso = usuarioService.buscaAcessoUsuario(usuario.getId(), "ROLE_ADMIM");

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException("Apenas empresas cadastradas no sistema podem apagar uma produto");

		if (!usuario.getEmpresa().equals(produto.getEmpresa()) && resultConsultaAcesso.isEmpty())
			throw new UsuarioNaoAutorisadoException("Você só pode apagar uma produto se for admim da empresa");

		try {
			buscaPorId(id);
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		}
	}

	private Produto convertdto(ProdutoDtoRequest dto, Produto produto, PessoaJuridica pessoaJuridica) {

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

		produto.setEmpresa(pessoaJuridica);
		produto.setMarcaProduto(marcaProdutoService.buscaPorId(dto.getMarcaProduto().getId()));
		produto.setCategoriaProduto(categoriaProdutoService.buscaPorId(dto.getCategoriaProduto().getId()));

		return produto;
	}
}
