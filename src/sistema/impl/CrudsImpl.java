package sistema.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import sistema.Cruds;
import sistema.SistemaException;
import dao.ProdutoDao;
import dominio.Produto;


public class CrudsImpl implements Cruds {

	@Inject
	private ProdutoDao ProdutoDao;
	@Inject 
	private EntityManager em;
	
	//ok
	public Produto buscar(int cod) {
		return ProdutoDao.buscar(cod);
	}


    //ok
	public void inserirProduto(Produto x) throws SistemaException {
		try {
			em.getTransaction().begin();
			ProdutoDao.inserir(x);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
			throw new SistemaException("Erro: " + e.getMessage());
		}
	}
    //ok
	public Produto atualizarProduto(Produto x) throws SistemaException {
		try {
			em.getTransaction().begin();
			Produto aux = ProdutoDao.atualizar(x);
			em.getTransaction().commit();
			return aux;
		}
		catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
			throw new SistemaException("Erro: " + e.getMessage());
		}
	}
	//ok
	public void deletarProduto(int cod) throws SistemaException {
		try {
			em.getTransaction().begin();
			Produto aux = ProdutoDao.buscar(cod);
			ProdutoDao.deletar(aux);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
			throw new SistemaException("Erro: " + e.getMessage());
		}
	}
//ok
	public List<Produto> buscarTodos() {
		return ProdutoDao.buscarTodos();
	}





}
