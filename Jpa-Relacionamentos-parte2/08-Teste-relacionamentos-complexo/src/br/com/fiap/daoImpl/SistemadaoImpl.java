package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.SistemaDAO;
import br.com.fiap.entity.Sistema;

public class SistemadaoImpl extends GenericDaoImpl<Sistema,Integer> implements SistemaDAO {

	public SistemadaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
