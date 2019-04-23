package br.com.fiap.dao;

import br.com.fiap.dao.exception.CodInexistenteException;
import br.com.fiap.dao.exception.CommitException;
import br.com.fiap.entity.Livro;

public interface GenericDAO<T,K> {
void cadastrar(T tabela);
void remover(K codigo ) throws CodInexistenteException;
void atualizar(T tabela);
T buscar(K codigo);
void commit() throws CommitException;
}
