package br.com.fiap.teste;


import java.util.List;

import javax.persistence.EntityManager;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Cliente;



class ReservaDAOImplTeste {

private static ReservaDAO cdao;
	
	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		cdao = new ReservaDAOImpl(em);
		
	}

	@Test
	public void listarReservaporCliente() {
		List<Cliente> lista = cdao.listarPorQtdDiasdeReserva(2);
		
	
	}

}
