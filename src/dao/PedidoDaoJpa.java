package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Pedido;

public class PedidoDaoJpa implements PedidoDao {

	@Inject
	private EntityManager em;

	public void inserir(Pedido x) {
		em.persist(x);
	}

	public Pedido atualizar(Pedido x) {
		return em.merge(x);
	}

	public void deletar(Pedido x) {
		em.remove(x);
	}

	public Pedido buscar(int cod) {
		return em.find(Pedido.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> buscarTodos() {
		String s = "SELECT u FROM Pedido u";
		Query query = em.createQuery(s);
		return query.getResultList();
	}
}
