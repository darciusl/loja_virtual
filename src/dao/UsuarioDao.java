package dao;

import java.util.List;
import dominio.Usuario;

public interface UsuarioDao {
	public void inserir(Usuario x);

	public Usuario atualizar(Usuario x);

	public void deletar(Usuario x);

	public Usuario buscar(int cod);

	public List<Usuario> buscarTodos();

	public Usuario buscarPorEmail(String email);
}