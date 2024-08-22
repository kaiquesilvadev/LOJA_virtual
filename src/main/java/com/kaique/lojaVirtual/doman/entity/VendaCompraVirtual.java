package com.kaique.lojaVirtual.doman.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_venda_compra_virtual")
public class VendaCompraVirtual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Pessoa pessoa;

	@ManyToOne
	private Endereco enderecoEntrega;

	@ManyToOne
	private Endereco enderecoCobranca;

	private BigDecimal valortotal;
	private BigDecimal valorDesconto;

	/* TODO forma de pagamento aqui */

	/* TODO notafiscalVenda aqui */

	/* TODO cupDsc aqui */

	private BigDecimal valorfrete;
	private Integer diasentrega;
	private Date dataVenda;
	private String urlImprimeEtiqueta;
	
	/*implementar get e set depois de mapear tudo*/

	public VendaCompraVirtual() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaCompraVirtual other = (VendaCompraVirtual) obj;
		return Objects.equals(id, other.id);
	}

}
