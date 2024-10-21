package com.kaique.lojaVirtual.domain.dto.request;

import java.math.BigDecimal;
import java.sql.Date;

import com.kaique.lojaVirtual.domain.dto.referencias.EmpresaRefDto;
import com.kaique.lojaVirtual.domain.dto.referencias.PessoaRefDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ContaPagarRequestDto {

	@NotBlank
	private String descricao;

	@NotNull
	@Positive
	private BigDecimal valortotal;

	@NotNull
	@Positive
	private BigDecimal valorDesconto;

	@FutureOrPresent
	@NotNull
	private Date dtVencimento;

	@FutureOrPresent
	@NotNull
	private Date dtPagamento;

	@Valid
	@NotNull
	private PessoaFornecedoRequestDto PessoaFornecedoRequestDto;


	/* TODO : colocar depois o dto de notaFiscalCompra */
	// private NotaFiscalCompra notaFiscalCompra;

	@Valid
	@NotNull
	private EnderecoRequestDto endereco;

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

	public PessoaFornecedoRequestDto getPessoaFornecedoDto() {
		return PessoaFornecedoRequestDto;
	}

	public void setPessoaFornecedoDto(PessoaFornecedoRequestDto PessoaFornecedoRequestDto) {
		this.PessoaFornecedoRequestDto = PessoaFornecedoRequestDto;
	}

	public EnderecoRequestDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequestDto endereco) {
		this.endereco = endereco;
	}

}
