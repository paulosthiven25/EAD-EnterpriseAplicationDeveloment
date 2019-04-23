package br.com.fiap.DAOImpl;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.EscolaDAO;
import br.com.fiap.entity.Escola;

public class EscolaDAOImpl extends GenericDAOImpl<Escola,Integer> implements EscolaDAO {

	public EscolaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
