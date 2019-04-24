package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AgenciaDAO;
import br.com.fiap.entity.Agencia;

public class AgenciaDAOImpl extends GenericDAOImpl <Agencia, Integer> implements AgenciaDAO{

	public AgenciaDAOImpl(EntityManager em) {
		super(em);
		
	}

}
