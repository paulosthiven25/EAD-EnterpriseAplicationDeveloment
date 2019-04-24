package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.entity.Conta;

public class ContaDAOImpl extends GenericDAOImpl<Conta, Integer> implements ContaDAO{

	public ContaDAOImpl(EntityManager em) {
		super(em);
		
	}

}
