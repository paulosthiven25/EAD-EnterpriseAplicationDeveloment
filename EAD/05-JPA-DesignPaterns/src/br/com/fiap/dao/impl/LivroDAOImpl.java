package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDao;
import br.com.fiap.entity.Livro;

public final class LivroDAOImpl extends GenericDAOImpl<Livro,Integer> implements LivroDao{

	public LivroDAOImpl(EntityManager em) {
		super(em);
		
	}

}
