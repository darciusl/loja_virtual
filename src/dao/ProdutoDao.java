package dao;

import java.util.List;
import dominio.Produto;

public interface ProdutoDao {
	public void inserir(Produto x);
	public Produto atualizar(Produto x);
	public void deletar(Produto x);
	public Produto buscar(int cod);
	public List<Produto> buscarTodos();
}
