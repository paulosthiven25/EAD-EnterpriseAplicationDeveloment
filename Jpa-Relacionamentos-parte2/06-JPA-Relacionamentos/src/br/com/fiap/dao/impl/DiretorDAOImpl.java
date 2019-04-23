package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.DiretorDAO;
import br.com.fiap.entity.Diretor;

public class DiretorDAOImpl 
		extends GenericDAOImpl<Diretor, Integer> implements DiretorDAO {

	public DiretorDAOImpl(EntityManager em) {
		super(em);
	}

}
