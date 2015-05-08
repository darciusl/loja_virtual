package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Usuario;

public class UsuarioDaoJpa implements UsuarioDao {

	@Inject
	private EntityManager em;

	public void inserir(Usuario x) {
		em.persist(x);
	}

	public Usuario atualizar(Usuario x) {
		return em.merge(x);
	}

	public void deletar(Usuario x) {
		em.remove(x);
	}

	public Usuario buscar(int cod) {
		return em.find(Usuario.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		String s = "SELECT u FROM Usuario u";
		Query query = em.createQuery(s);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Usuario buscarPorEmail(String email) {
		String s = "SELECT u FROM Usuario u WHERE email = :p1";
		Query query = em.createQuery(s);
		query.setParameter("p1", email);
		List<Usuario> aux = query.getResultList();
		if (!aux.isEmpty())
			return aux.get(0);
		else
			return null;
	}
}
