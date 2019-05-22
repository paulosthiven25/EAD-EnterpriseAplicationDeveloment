package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class PedidoDAOImpl extends GenericDAOImpl<Pedido,Integer> implements PedidoDAO {

	public PedidoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long contarPedidosporCliente(int codigo) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(p) from Pedido p where p.cliente.codigo = :cli",Long.class).setParameter("cli",codigo).getSingleResult();
	}

}
