package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Produto;

public class ProdutoDaoJpa implements ProdutoDao {

	@Inject
	private EntityManager em;

	public void inserir(Produto x) {
		em.persist(x);
	}

	public Produto atualizar(Produto x) {
		return em.merge(x);
	}

	public void deletar(Produto x) {
		em.remove(x);
	}

	public Produto buscar(int cod) {
		return em.find(Produto.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> buscarTodos() {
		String s = "SELECT u FROM Produto u";
		Query query = em.createQuery(s);
		return query.getResultList();
	}
}
