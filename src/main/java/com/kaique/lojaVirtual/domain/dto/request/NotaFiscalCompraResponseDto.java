package com.kaique.lojaVirtual.domain.dto.request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kaique.lojaVirtual.domain.dto.referencias.PessoaRefDto;
import com.kaique.lojaVirtual.domain.dto.response.NotaItemProdutoDtoResponce;
import com.kaique.lojaVirtual.domain.entity.NotaFiscalCompra;

public class NotaFiscalCompraResponseDto {

	private Long id;
	private String numeroNota;
	private String serieNota;
	private String descricaoOds;
	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	private BigDecimal valorIcms;
	private OffsetDateTime dataCompra;
	private PessoaRefDto pessoa;
	private PessoaRefDto empresa;
	private List<NotaItemProdutoDtoResponce> notaItemProdutos = new ArrayList<>();

	public NotaFiscalCompraResponseDto() {
	}

	public NotaFiscalCompraResponseDto(NotaFiscalCompra notaFiscalCompra) {
		this.id = notaFiscalCompra.getId();
		this.numeroNota = notaFiscalCompra.getNumeroNota();
		this.serieNota = notaFiscalCompra.getSerieNota();
		this.descricaoOds = notaFiscalCompra.getDescricaoOds();
		this.valorTotal = notaFiscalCompra.getValorTotal();
		this.valorDesconto = notaFiscalCompra.getValorDesconto();
		this.valorIcms = notaFiscalCompra.getValorIcms();
		this.dataCompra = notaFiscalCompra.getDataCompra();
		this.pessoa = new PessoaRefDto(notaFiscalCompra.getPessoa());
		this.empresa = new PessoaRefDto(notaFiscalCompra.getEmpresa());
		this.notaItemProdutos = notaFiscalCompra.getNotaItemProdutos().stream()
				.map(x -> new NotaItemProdutoDtoResponce(x)).toList();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getSerieNota() {
		return serieNota;
	}

	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

	public String getDescricaoOds() {
		return descricaoOds;
	}

	public void setDescricaoOds(String descricaoOds) {
		this.descricaoOds = descricaoOds;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(BigDecimal valorIcms) {
		this.valorIcms = valorIcms;
	}

	public OffsetDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(OffsetDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public PessoaRefDto getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaRefDto pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaRefDto getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaRefDto empresa) {
		this.empresa = empresa;
	}

	public List<NotaItemProdutoDtoResponce> getNotaItemProdutos() {
		return notaItemProdutos;
	}

	public void setNotaItemProdutos(List<NotaItemProdutoDtoResponce> notaItemProdutos) {
		this.notaItemProdutos = notaItemProdutos;
	}

}
