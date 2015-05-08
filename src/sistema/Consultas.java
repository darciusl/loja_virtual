package sistema;

import java.util.List;
import dominio.Produto;
import dominio.Usuario;

public interface Consultas {
	public List<Produto> buscarTodosProdutos();

	public Produto buscarProduto(int cod);

	public Usuario buscarPorEmail(String email);
}