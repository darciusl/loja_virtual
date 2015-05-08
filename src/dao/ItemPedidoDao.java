package dao;

import java.util.List;

import dominio.ItemPedido;

public interface ItemPedidoDao {
	public void inserir(ItemPedido x);
	public ItemPedido atualizar(ItemPedido x);
	public void deletar(ItemPedido x);
	public ItemPedido buscar(int cod);
	public List<ItemPedido> buscarTodos();
}
