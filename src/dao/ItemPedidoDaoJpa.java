package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.*;

import dominio.ItemPedido;

public class ItemPedidoDaoJpa implements ItemPedidoDao {

	@Inject
	private EntityManager em;

	public void inserir(ItemPedido x) {
		em.persist(x);
	}

	public ItemPedido atualizar(ItemPedido x) {
		return em.merge(x);
	}

	public void deletar(ItemPedido x) {
		em.remove(x);
	}

	public ItemPedido buscar(int cod) {
		return em.find(ItemPedido.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<ItemPedido> buscarTodos() {
		String s = "SELECT u FROM ItemCarrinho u";
		Query query = em.createQuery(s);
		return query.getResultList();
	}
}
