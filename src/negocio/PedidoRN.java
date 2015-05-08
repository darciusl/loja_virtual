package negocio;

import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.ItemPedidoDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import dominio.Carrinho;
import dominio.ItemCarrinho;
import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Produto;

public class PedidoRN {

	@Inject
	private ProdutoDao produtoDao;
	@Inject
	private PedidoDao pedidoDao;
	@Inject
	private ItemPedidoDao itemPedidoDao;
	@Inject
	private EntityManager em;

	public Pedido finalizarPedido(Carrinho car) throws RNException {

		if (car.getItens().isEmpty()) {
			throw new RNException("Nao se pode fechar pedido com carrinho vazio");
		}

		em.getTransaction().begin();

		for (ItemCarrinho ic : car.getItens()) {
			Produto p = produtoDao.buscar(ic.getProduto().getCodProduto());
			if (p.getQtdEstoque() < ic.getQtde()) {
				throw new RNException("Quantidade do produto "+p.getNome()+" insuficiente");
			}
			p.setQtdEstoque(p.getQtdEstoque() - ic.getQtde());
			//p = produtoDao.atualizar(p); // nem precisa disso em JPA
			ic.setProduto(p);
		}

		try {
			
			Pedido pedido = new Pedido(null, "AGUARDANDO_PAGAMENTO", new Date(), null);
			pedidoDao.inserir(pedido);

			for (ItemCarrinho ic : car.getItens()) {
				ItemPedido ip = new ItemPedido(null, ic.getQtde(), ic.getProduto().getPreco(), ic.getProduto(), pedido);
				itemPedidoDao.inserir(ip);
			}

			em.getTransaction().commit();
			car.getItens().clear();

			return pedido;

		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
			throw new RNException("Erro na transacao ao finalizar pedido!");
		}
	}
}
