package sistema.impl;

import java.util.List;

import javax.inject.Inject;

import sistema.Consultas;
import dao.ProdutoDao;
import dominio.Produto;
import dominio.Usuario;
import dao.UsuarioDao;

public class ConsultasImpl implements Consultas {

	@Inject
	private ProdutoDao produtoDao;
	@Inject
	private UsuarioDao usuarioDao;
	
	public Produto buscarProduto(int cod) {
		return produtoDao.buscar(cod);
	}

	public List<Produto> buscarTodosProdutos() {
		return produtoDao.buscarTodos();
	}
	public Usuario buscarPorEmail(String email) {
		 return usuarioDao.buscarPorEmail(email);
		 } 
}
