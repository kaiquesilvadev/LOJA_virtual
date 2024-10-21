package com.kaique.lojaVirtual.domain.dto.response;

import java.math.BigDecimal;
import java.sql.Date;

import com.kaique.lojaVirtual.domain.dto.referencias.PessoaRefDto;
import com.kaique.lojaVirtual.domain.dto.request.NotaFiscalCompraResponseDto;
import com.kaique.lojaVirtual.domain.entity.ContaPagar;
import com.kaique.lojaVirtual.domain.enuns.StatusContaPagar;

public class ContaPagarResponseDto {

	private Long id;
	private String descricao;
	private BigDecimal valortotal;
	private BigDecimal valorDesconto;
	private Date dtVencimento;
	private Date dtPagamento;
	private StatusContaPagar status;
	private PessoaFornecedoResponseDto pessoaFornecedo;
	private PessoaRefDto empresa;
	// private NotaFiscalCompraResponseDto notaFiscalCompra;
	private EnderecoRespCustoDto endereco;

	public ContaPagarResponseDto() {
	}

	public ContaPagarResponseDto(ContaPagar contaPagar) {
		this.id = contaPagar.getId();
		this.descricao = contaPagar.getDescricao();
		this.valortotal = contaPagar.getValortotal();
		this.valorDesconto = contaPagar.getValorDesconto();
		this.dtVencimento = contaPagar.getDtVencimento();
		this.dtPagamento = contaPagar.getDtPagamento();
		this.status = contaPagar.getStatus();
		this.pessoaFornecedo = new PessoaFornecedoResponseDto(contaPagar.getPessoaFornecedo());
		this.empresa = new PessoaRefDto(contaPagar.getEmpresa().getId(), contaPagar.getEmpresa().getNome());
		// this.notaFiscalCompra = new
		// NotaFiscalCompraResponseDto(contaPagar.getNotaFiscalCompra());
		this.endereco = new EnderecoRespCustoDto(contaPagar.getEndereco());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public StatusContaPagar getStatus() {
		return status;
	}

	public void setStatus(StatusContaPagar status) {
		this.status = status;
	}

	public PessoaFornecedoResponseDto getPessoaFornecedo() {
		return pessoaFornecedo;
	}

	public void setPessoaFornecedo(PessoaFornecedoResponseDto pessoaFornecedo) {
		this.pessoaFornecedo = pessoaFornecedo;
	}

	public PessoaRefDto getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaRefDto empresa) {
		this.empresa = empresa;
	}

	/*
	 * public NotaFiscalCompraResponseDto getNotaFiscalCompra() { return
	 * notaFiscalCompra; }
	 */

	/*
	 * public void setNotaFiscalCompra(NotaFiscalCompraResponseDto notaFiscalCompra)
	 * { this.notaFiscalCompra = notaFiscalCompra; }
	 */

	public EnderecoRespCustoDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRespCustoDto endereco) {
		this.endereco = endereco;
	}

}
