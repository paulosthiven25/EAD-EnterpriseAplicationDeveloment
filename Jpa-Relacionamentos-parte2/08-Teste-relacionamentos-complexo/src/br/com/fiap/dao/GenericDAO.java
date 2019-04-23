package br.com.fiap.dao;

import br.com.fiap.exception.CodigoInexixtenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T,K> {
void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T buscar(K codigo) throws CodigoInexixtenteException;
	
	void remover(K codigo) throws CodigoInexixtenteException;
	
	void commit() throws CommitException;
}
