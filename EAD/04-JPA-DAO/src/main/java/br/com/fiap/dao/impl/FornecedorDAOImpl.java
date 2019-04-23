package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.FornecedorDAO;
import br.com.fiap.entity.Fornecedor;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class FornecedorDAOImpl implements FornecedorDAO {

	private EntityManager em;
	
	public FornecedorDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	public void gravar(Fornecedor fornecedor) {
		em.persist(fornecedor);
	}

	public void remover(int codigo) throws CodigoInexistenteException {
		Fornecedor f = em.find(Fornecedor.class, codigo);
		if (f == null) {
			throw new CodigoInexistenteException();
		}
		em.remove(f);
	}

	public Fornecedor pesquisar(int codigo) {
		Fornecedor busca = em.find(Fornecedor.class, codigo);
		return busca;
	}

	public void alterar(Fornecedor fornecedor) {
		em.merge(fornecedor);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException("Erro no commit");
		}
	}

	
	
}