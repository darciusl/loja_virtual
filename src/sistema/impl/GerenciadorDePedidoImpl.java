package sistema.impl;

import javax.inject.Inject;

import negocio.PedidoRN;
import negocio.RNException;
import sistema.SistemaException;
import sistema.GerenciadorDePedido;
import dominio.Carrinho;
import dominio.Pedido;

public class GerenciadorDePedidoImpl implements GerenciadorDePedido {

	@Inject
	private PedidoRN pedidoRN;
	
	public Pedido registrarPedido(Carrinho car) throws SistemaException {
		try {
			return pedidoRN.finalizarPedido(car);
		}
		catch (RNException e) {
			System.out.println(e.getMessage());
			throw new SistemaException("Erro: " + e.getMessage());
		}
	}
}
