package dominio;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "tb_itempedido")
public class ItemPedido {

	@Id
	@GeneratedValue
	private Integer codItemPedido;

	private Integer qtde;

	private BigDecimal preco;

	@ManyToOne
	@JoinColumn(name = "produto")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "pedido")
	private Pedido pedido;

	public ItemPedido() {
	}

	public ItemPedido(Integer codItemPedido, Integer qtde, BigDecimal preco,
			Produto produto, Pedido pedido) {
		this.codItemPedido = codItemPedido;
		this.qtde = qtde;
		this.preco = preco;
		this.produto = produto;
		this.pedido = pedido;
	}

	public Integer getCodItemPedido() {
		return codItemPedido;
	}

	public void setCodItemPedido(Integer codItemPedido) {
		this.codItemPedido = codItemPedido;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codItemPedido == null) ? 0 : codItemPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (codItemPedido == null) {
			if (other.codItemPedido != null)
				return false;
		} else if (!codItemPedido.equals(other.codItemPedido))
			return false;
		return true;
	}
}
