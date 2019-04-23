package br.com.fiap.DAO;

import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T,K> {
void cadastrar(T entidade);
void atualizar(T entidade);
T buscar(K codigo) throws CodigoInexistenteException;
void remover(K codigo) throws CodigoInexistenteException;
void commit() throws CommitException;
	
}
