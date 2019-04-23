package br.com.fiap.DAOImpl;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.ProfessorDAO;
import br.com.fiap.entity.Professor;

public class ProfessorDAOImpl extends GenericDAOImpl<Professor,Integer> implements ProfessorDAO  {

	public ProfessorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
