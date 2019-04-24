package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
	TypedQuery<Cliente> q = em.createNamedQuery("Cliente.listar",Cliente.class);
	return q.getResultList();
	}

	@Override
	public List<Cliente> listarPorNome(String nome) {
		TypedQuery<Cliente> q = em.createQuery("from Cliente c where upper(c.nome) like upper(:nom) order by c.nome ",Cliente.class);
		q.setParameter("nom","%"+nome+"%");
		return q.getResultList();
	}

	@Override
	public List<Cliente> listarPorEstado(String uf) {
		TypedQuery<Cliente> q = em.createQuery("from Cliente c where c.endereco.cidade.uf like :vuf",Cliente.class);
		q.setParameter("vuf","%"+uf.toUpperCase()+"%");
		return q.getResultList();
	}

	@Override
	public List<Cliente> listarPorQtdDiasdeReserva(int dia) {
		TypedQuery<Cliente> q = em.createQuery("select v.cliente from Reserva v where v.numeroDias = :dias",Cliente.class);
		q.setParameter("dias",dia);
		return q.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		
		return em.createQuery("from Cliente c where c.nome like :n and c.endereco.cidade.nome like :c",Cliente.class).setParameter("n","%"+nome+"%").setParameter("c","%"+cidade+"%").getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(List<String> estados) {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :e",Cliente.class).setParameter("e",estados).getResultList();
	}

	@Override
	public List<Cliente> listar3ClientesMaisNovos() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente c order by c.dataNascimneto",Cliente.class).getResultList();
	}

	@Override
	public long qtddeClientesPorEstado(String uf) {
	
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf = :estado",Long.class)
				.setParameter("estado",uf).getSingleResult();
	}
	
	public List<String> listarCpf(){
		return em.createNamedQuery("Cliente.porCpf",String.class).getResultList();
	}
	
	public List<Cliente> listarNomeeCpfPorCep(int cpf){
		return em.createNamedQuery("Cliente.listarCpfENomePorCep",Cliente.class).setParameter("c",cpf ).getResultList();
	}
	

}
