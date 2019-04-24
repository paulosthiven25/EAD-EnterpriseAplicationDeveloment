package br.com.fiap.dao.impl;

import br.com.fiap.entity.ConsultaPK;
import javax.persistence.EntityManager;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.entity.Consulta;

public class ConsultaDAOImpl extends GenericDAOImpl<Consulta, ConsultaPK> implements ConsultaDAO{

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
	}

}
