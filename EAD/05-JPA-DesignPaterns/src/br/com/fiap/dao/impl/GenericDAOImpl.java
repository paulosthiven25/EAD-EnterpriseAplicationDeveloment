package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.dao.exception.CodInexistenteException;
import br.com.fiap.dao.exception.CommitException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T,K> {
	private EntityManager em;
	
	private Class<T> classz;
	
	public GenericDAOImpl(EntityManager em) {
		this.em=em;
		classz=(Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void cadastrar(T tabela) {
		em.persist(tabela);
		
		
	}

	public void remover(K codigo) throws CodInexistenteException {
		T tabela =(buscar(codigo));
		if(tabela == null) {
			throw new CodInexistenteException("Código inexixtente");
			
		}
		em.remove(tabela);
	}

	public void atualizar(T tabela) {
		em.merge(tabela);
		
	}

	public T buscar(K codigo) {
	   return em.find(classz,codigo);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
			
		} catch (Exception e) {
		e.printStackTrace();
		em.getTransaction().rollback();
		throw new CommitException();
		}
		
		
	}

}
