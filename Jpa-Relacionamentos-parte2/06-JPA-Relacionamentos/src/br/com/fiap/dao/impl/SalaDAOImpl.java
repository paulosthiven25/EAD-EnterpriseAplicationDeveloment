package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.SalaDAO;
import br.com.fiap.entity.Sala;

public class SalaDAOImpl extends GenericDAOImpl<Sala, Integer> implements SalaDAO{

	public SalaDAOImpl(EntityManager em) {
		super(em);
	}

}
