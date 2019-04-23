package br.com.fiap.daoImpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CodigoInexixtenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDaoImpl<T,K> implements GenericDAO<T,K> {
     private EntityManager em;
     private Class<T> classz;
    
     @SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		super();
		this.em = em;
		this.classz=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}

	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
		
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
		
	}

	@Override
	public T buscar(K codigo) throws CodigoInexixtenteException {
		T busca = em.find(classz, codigo);
		if(busca==null) {
			throw new CodigoInexixtenteException() ;
		}
		return busca;
	}

	@Override
	public void remover(K codigo) throws CodigoInexixtenteException {
	em.remove(buscar(codigo));
		
	}

	@Override
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
