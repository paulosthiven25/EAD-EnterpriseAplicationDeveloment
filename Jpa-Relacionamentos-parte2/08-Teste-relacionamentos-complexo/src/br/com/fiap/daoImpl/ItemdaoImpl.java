package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemDAO;
import br.com.fiap.entity.Item;

public class ItemdaoImpl extends GenericDaoImpl<Item,Integer> implements ItemDAO {

	public ItemdaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
