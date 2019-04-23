package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EscolaDAO;
import br.com.fiap.entity.Escola;

public class EscolaDAOImpl extends GenericDAOImpl<Escola, Integer> implements EscolaDAO{

	public EscolaDAOImpl(EntityManager em) {
		super(em);
	}

}
