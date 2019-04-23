package br.com.fiap.daoImpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T,K> {
	private EntityManager em;
	private Class<T> classz;
	
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		classz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T tabela) {
		em.persist(tabela);
		
	}

	@Override
	public void remover(K codigo) throws CodigoInexistenteException {
		// TODO Auto-generated method stub
		em.remove(buscar(codigo));
	}

	@Override
	public void atualizar(T tabela) {
		em.merge(tabela);
		
	}

	@Override
	public T buscar(K codigo) throws CodigoInexistenteException {
	T tabela = 	em.find(classz,codigo);
	if(tabela==null){
		throw new CodigoInexistenteException();
	}
		
		return tabela;
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
