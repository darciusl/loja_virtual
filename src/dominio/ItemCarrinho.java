package dominio;

import java.math.BigDecimal;

public class ItemCarrinho {
	private Integer qtde;
	private Produto produto;

	public ItemCarrinho(Integer qtde, Produto produto) {
		this.qtde = qtde;
		this.produto = produto;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void incrementarQtde() {
		this.qtde++;
	}

	public void decrementarQtde() {
		this.qtde--;
	}

	public BigDecimal subTotal() {
		BigDecimal aux = new BigDecimal(this.qtde);
		return aux.multiply(produto.getPreco());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemCarrinho other = (ItemCarrinho) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
}
