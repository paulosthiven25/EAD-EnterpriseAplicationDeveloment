package br.com.fiap.DAOImpl;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.DiretorDAO;
import br.com.fiap.entity.Diretor;

public class DiretorDAOImpl extends GenericDAOImpl<Diretor,Integer> implements DiretorDAO  {

	public DiretorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
