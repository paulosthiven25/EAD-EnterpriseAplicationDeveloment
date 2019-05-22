package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public interface PedidoDAO extends GenericDAO<Pedido,Integer> {
	long contarPedidosporCliente(int codigo);
}
