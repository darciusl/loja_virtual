package dao;

import java.util.List;
import dominio.Pedido;

public interface PedidoDao {
	public void inserir(Pedido x);
	public Pedido atualizar(Pedido x);
	public void deletar(Pedido x);
	public Pedido buscar(int cod);
	public List<Pedido> buscarTodos();
}
