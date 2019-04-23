
package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

public class UsuariodaoImpl extends GenericDaoImpl<Usuario,Integer> implements UsuarioDAO{

	public UsuariodaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
