package com.kaique.lojaVirtual.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaique.lojaVirtual.domain.dto.ImagemProdutoDto;
import com.kaique.lojaVirtual.domain.entity.ImagemProduto;
import com.kaique.lojaVirtual.domain.entity.PessoaJuridica;
import com.kaique.lojaVirtual.domain.entity.Produto;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeEmUsoException;
import com.kaique.lojaVirtual.domain.exceptions.EntidadeNaoEncontradaException;
import com.kaique.lojaVirtual.domain.exceptions.UsuarioNaoAutorisadoException;
import com.kaique.lojaVirtual.domain.repositories.ImagemProdutoRepository;
import com.kaique.lojaVirtual.domain.repositories.ProdutoRepository;

@Service
public class ImagemProdutoService {

	@Autowired
	private ImagemProdutoRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ImplementacaoUserDetailsServices detailsServices;

	@Transactional(propagation = Propagation.SUPPORTS)
	public ImagemProduto buscaPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ID de código '" + id + "' não encontrado ."));
	}

	/*
	 * TODO :img do produto so pode ser salva se o produto tiver menos de 6 imagem
	 * cadastradas ja.
	 */
	@Transactional
	public ImagemProduto Salva(ImagemProdutoDto dto, Produto produto) {
		Usuario usuario = detailsServices.authenticated();
		Integer qtdImg = produtoRepository.quantidadeImg(produto.getId());

		if (qtdImg >= 6)
			throw new UsuarioNaoAutorisadoException(
					"Não pode ser feita a inserção de uma nova imagem pois já existem 6 imagens cadastradas no sistema.");

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException("Apenas empresas cadastradas no sistema podem salvar uma img");

		ImagemProduto imagemProduto = convertdto(dto, new ImagemProduto(), usuario.getEmpresa(), produto);
		return repository.save(imagemProduto);
	}

	/* TODO : você só pode atualizar uma img da sua propria empresa */
	@Transactional
	public ImagemProduto atualizar(ImagemProdutoDto dto, Long id, Produto produto) {
		Usuario usuario = detailsServices.authenticated();
		ImagemProduto img = buscaPorId(id);

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException("Apenas empresas cadastradas no sistema podem atualizar uma img");

		if (!usuario.getEmpresa().equals(img.getEmpresa()))
			throw new UsuarioNaoAutorisadoException("Apenas a propria empresa pode atualizar sua propria imagem.");

		ImagemProduto produtoAtualizado = convertdto(dto, img, img.getEmpresa(), img.getProduto());

		return repository.save(produtoAtualizado);
	}

	/* TODO : voce so pode deletar produto se tiver mais de 3 img salvas */
	@Transactional
	public void deletar(Long id) {

		Usuario usuario = detailsServices.authenticated();
		ImagemProduto img = buscaPorId(id);

		if (usuario.getEmpresa() == null)
			throw new UsuarioNaoAutorisadoException("Apenas empresas cadastradas no sistema podem apagar uma img");

		if (!usuario.getEmpresa().equals(img.getEmpresa()))
			throw new UsuarioNaoAutorisadoException("Apenas a propria empresa pode apagar sua propria imagem.");

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		}
	}

	@Transactional
	public void deletaTodasImg(Long idProduto) {
		repository.deletaTodaImgPorIdProduto(idProduto);
	}

	protected ImagemProduto convertdto(ImagemProdutoDto dto, ImagemProduto imagemProduto, PessoaJuridica juridica,
			Produto produto) {

		imagemProduto.setImagemOriginal(dto.getImagemOriginal());
		imagemProduto.setImagemMiniatura(dto.getImagemMiniatura());
		imagemProduto.setLinkTouTuber(dto.getLinkTouTuber());
		imagemProduto.setProduto(produto);
		imagemProduto.setEmpresa(juridica);

		return imagemProduto;
	}
}
