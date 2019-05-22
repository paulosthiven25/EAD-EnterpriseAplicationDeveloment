package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer> {
	
	List<Cliente> buscapordata (Calendar d1,Calendar d2);

}
