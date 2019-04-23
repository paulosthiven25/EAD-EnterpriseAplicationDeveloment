package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<Cliente> listarPorQtdDiasdeReserva(int dia) {
		TypedQuery<Cliente> q = em.createQuery("select Cliente from Reserva v where v.numeroDias = :dias",Cliente.class);
		q.setParameter(":dias",dia);
		return q.getResultList();
	}
}
