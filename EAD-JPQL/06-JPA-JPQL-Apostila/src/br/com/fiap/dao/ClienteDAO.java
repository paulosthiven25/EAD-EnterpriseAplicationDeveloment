package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	List<Cliente> listar ();
	List<Cliente> listarPorNome(String nome);
	List<Cliente> listarPorEstado(String uf);
	List<Cliente> listarPorQtdDiasdeReserva(int dia);
	List<Cliente> buscar(String nome,String cidade);
	List<Cliente> buscarPorEstado(List<String> estados);
	List<Cliente> listar3ClientesMaisNovos ();
	long qtddeClientesPorEstado (String uf);
	List<String> listarCpf();
	public Cliente listarNomeeCpfPorCep(int cep);
	

}
