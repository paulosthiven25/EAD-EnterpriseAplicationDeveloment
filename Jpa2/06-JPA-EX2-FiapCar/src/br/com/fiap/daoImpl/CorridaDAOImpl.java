package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.CorridaPK;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida,CorridaPK> implements CorridaDAO {

	public CorridaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
