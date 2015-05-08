package sistema.impl;

import javax.inject.Inject;

import sistema.GerenciadorDeCarrinho;
import dao.ProdutoDao;
import dominio.Carrinho;
import dominio.Produto;

public class GerenciadorDeCarrinhoImpl implements GerenciadorDeCarrinho {

	@Inject
	private ProdutoDao produtoDao;
	
	public void incrementarItem(Carrinho car, int codProduto) {
		Produto prod = produtoDao.buscar(codProduto);
		car.incrementaQtde(prod);
	}

	public void decrementarItem(Carrinho car, int codProduto) {
		Produto prod = produtoDao.buscar(codProduto);
		car.decrementaQtde(prod);
	}

	public void inserirItem(Carrinho car, int codProduto, int qtde) {
		Produto prod = produtoDao.buscar(codProduto);
		car.insereItem(prod, qtde);
	}

	public void removerItem(Carrinho car, int codProduto) {
		Produto prod = produtoDao.buscar(codProduto);
		car.removeItem(prod);
	}
}
