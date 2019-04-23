package br.com.fiap.DAOImpl;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.SalaDAO;
import br.com.fiap.entity.Sala;

public class SalaDAOImpl extends GenericDAOImpl<Sala,Integer> implements SalaDAO {

	public SalaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
