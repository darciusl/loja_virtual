package sistema;

import dominio.Carrinho;
import dominio.Pedido;

public interface GerenciadorDePedido {

	public Pedido registrarPedido(Carrinho car) throws SistemaException;
}
