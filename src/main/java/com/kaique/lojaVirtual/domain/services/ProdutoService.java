package com.kaique.lojaVirtual.domain.services;

import java.util.ArrayList;
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
import com.kaique.lojaVirtual.domain.exceptions.EntidadeExistenteException;
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

	@Autowired
	private ImagemProdutoService imgProdutoService;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Produto buscaPorId(Long id) {
		return repository.buscaPorId(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ID de código '" + id + "' não encontrado ."));
	}

	// TODO : so quem pode salvar um novo produto e um admim ou alguem que seja levantado como admim da empresa
	// TODO : nao pode salvar um produto com o msm nome
	@Transactional
	public Produto Salva(ProdutoDtoRequest dto) {

		List<ImagemProduto> imagemProdutos = new ArrayList<>();

		Usuario usuario = validaAtualizaEsalvaProduto(dto);
		Produto produto = convertdto(dto, new Produto(), usuario.getEmpresa());

		for (int x = 0; x < dto.getImagemProdutos().size(); x++) {

			imagemProdutos.add(imgProdutoService.convertdto(dto.getImagemProdutos().get(x), new ImagemProduto(),
					usuario.getEmpresa(), produto));
		}

		produto.getImagemProdutos().addAll(imagemProdutos);
		return repository.save(produto);
	}

	//TODO so quem pode atualizar um produto e o admim da empresa
	@Transactional
	public Produto atualizar(ProdutoDtoRequest dto, Long id) {
		
		List<ImagemProduto> imagemProdutos = new ArrayList<>();
		
		Produto produto = buscaPorId(id);
		produto.getImagemProdutos().clear();
		Usuario usuario = validaAtualizaEsalvaProduto(dto);
		imgProdutoService.deletaTodasImg(produto.getId());

		if (!usuario.getEmpresa().equals(produto.getEmpresa()))
			throw new UsuarioNaoAutorisadoException("Você só pode atualiza um produto se for da sua propria empresa");
		
		for (int x = 0; x < dto.getImagemProdutos().size(); x++) {

			imagemProdutos.add(imgProdutoService.convertdto(dto.getImagemProdutos().get(x), new ImagemProduto(),
					usuario.getEmpresa(), produto));
		}

		produto.getImagemProdutos().addAll(imagemProdutos);
		return repository.save(convertdto(dto, produto, usuario.getEmpresa()));
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

	private Usuario validaAtualizaEsalvaProduto(ProdutoDtoRequest dto) {
		Usuario usuario = detailsServices.authenticated();
		Optional<Usuario> resultConsultaAcesso = usuarioService.buscaAcessoUsuario(usuario.getId(), "ROLE_ADMIN");

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException(
					"Apenas empresas cadastradas no sistema podem salvar ou atualizar uma produto");

		if (repository.existsByNomeAndEmpresa(dto.getNome(), usuario.getEmpresa().getId()))
			throw new EntidadeExistenteException("Produto com o nome '" + dto.getNome() + " já existene no sistema.");

		if (resultConsultaAcesso.isEmpty())
			throw new UsuarioNaoAutorisadoException("Apenas administradores podem adicionar ou salva um produto");

		return usuario;
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
