package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CasoTesteDAO;
import br.com.fiap.entity.CasoTeste;

public class CasoTestedaoImpl extends GenericDaoImpl<CasoTeste,Integer> implements CasoTesteDAO{

	public CasoTestedaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
