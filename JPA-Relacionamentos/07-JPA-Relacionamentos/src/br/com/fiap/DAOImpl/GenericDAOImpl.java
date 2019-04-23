package br.com.fiap.DAOImpl;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.DAO.GenericDAO;

import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T,K> {
	private EntityManager em;
	private Class<T> classz;
	
	

	public GenericDAOImpl(EntityManager em) {
		super();
		this.em =em;
		classz=(Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
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
	public T buscar(K codigo) throws CodigoInexistenteException {
		// TODO Auto-generated method stub
		T tabela = em.find(classz,codigo);
		if (tabela==null) {
			throw new CodigoInexistenteException();
		}
		return tabela;
			
	}

	@Override
	public void remover(K codigo) throws CodigoInexistenteException {
		
		em.remove(buscar(codigo));
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
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
