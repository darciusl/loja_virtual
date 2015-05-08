package sistema;

import dominio.Carrinho;

public interface GerenciadorDeCarrinho {
	public void incrementarItem(Carrinho car, int codProduto);
	public void decrementarItem(Carrinho car, int codProduto);
	public void inserirItem(Carrinho car, int codProduto, int qtde);
	public void removerItem(Carrinho car, int codProduto);
}
