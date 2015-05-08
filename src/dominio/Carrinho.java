package dominio;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Carrinho {
	private List<ItemCarrinho> itens;

	public Carrinho() {
		itens = new ArrayList<ItemCarrinho>();
	}

	public Carrinho(List<ItemCarrinho> ic) {
		this.itens = ic;
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}

	public void decrementaQtde(Produto prod) {
		ItemCarrinho aux = busca(prod);
		if (aux != null) {
			aux.decrementarQtde();
			if (aux.getQtde() < 1) {
				itens.remove(aux);
			}
		}
	}


	public void incrementaQtde(Produto prod) {
		ItemCarrinho aux = busca(prod);
		if (aux != null) {
			aux.incrementarQtde();
		}
	}

	
	public void insereItem(Produto prod, int qtde) {
		ItemCarrinho aux = busca(prod);
		if (aux == null) {
			aux = new ItemCarrinho(qtde, prod);
			itens.add(aux);
		}
	}
	
	public void removeItem(Produto prod) {
		ItemCarrinho aux = busca(prod);
		if (aux != null) {
			itens.remove(aux);
		}
	}

	public BigDecimal total() {
		BigDecimal soma = new BigDecimal("0.00");
		for (ItemCarrinho ic : this.itens) {
			soma = soma.add(ic.subTotal());
		}
		return soma;
	}

	private ItemCarrinho busca(Produto prod) {
		for (ItemCarrinho ic : itens) {
			if (prod.equals(ic.getProduto())){
				return ic;
			}
		}
		return null;
	}
}
