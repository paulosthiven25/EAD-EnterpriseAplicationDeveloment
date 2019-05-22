package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO {

	public ClienteDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cliente> buscapordata(Calendar d1, Calendar d2) {
		// TODO Auto-generated method stub
		return em.createQuery("select p.cliente from Pedido p where p.dataPedido between :data1 and :data2",Cliente.class).setParameter("data1",d1)
				.setParameter("data2",d2)
				.getResultList();
	}
	
	

	

}
