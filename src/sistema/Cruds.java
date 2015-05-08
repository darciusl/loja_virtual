package sistema;

import java.util.List;

import dominio.Produto;


public interface Cruds {
	
	// metodos relacionados a Album
	public List<Produto> buscarTodos();
	public Produto buscar(int cod);
	public void inserirProduto(Produto x) throws SistemaException;
	public Produto atualizarProduto(Produto x) throws SistemaException;
	public void deletarProduto(int cod) throws SistemaException;
}
