package br.com.fiap.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;


class ClienteDAOImplTeste {
private static ClienteDAO cdao;
	
	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		cdao = new ClienteDAOImpl(em);
		
	}

	@Test
	void listar() {
		List<Cliente> lista = cdao.listar();
		assertEquals(5,lista.size());
	}
	
	@Test
	void listarPorNome() {
		List<Cliente> lista = cdao.listarPorNome("J");
		assertEquals(2,lista.size());
		for(Cliente cliente:lista) {
			assertTrue(cliente.getNome().contains("J"));
			//assertNotEquals(-1,cliente.getNome().indexOf("T"));
		}
	}

	@Test
	void listarPorEstado() {
		List<Cliente> lista = cdao.listarPorEstado("BA");
		for (Cliente cliente : lista) {
			assertEquals(cliente.getEndereco().getCidade().getUf(),"BA");
		}
	}
	
	@Test
	public void listarReservaporCliente() {
		List<Cliente> lista = cdao.listarPorQtdDiasdeReserva(10);
		assertEquals(2,lista.size());
		}
	
	@Test
	public void buscarPorCidadeENome() {
		List<Cliente> lista = cdao.buscar("leandro","londrina");
		for(Cliente c:lista) {
			assertTrue(c.getNome().contains("leandro") && c.getEndereco().getCidade().getNome().contains("londrina"));
		}
	}
	
	@Test
	void buscarPorEstado() {
		List<String> estados = new ArrayList<String>();
		estados.add("SP");
		estados.add("PR");
		
		List<Cliente> lista = cdao.buscarPorEstado(estados);
		
		for(Cliente c : lista) {
			assertTrue(estados.contains(c.getEndereco().getCidade().getUf()));
			
		}
	}
	@Test
	 void qtddeClientesPorEstado() {
		long result = cdao.qtddeClientesPorEstado("SP");
		assertTrue(result==1);
	}
	
	@Test
	void listarCpfClientes() {
		List<String> lista = cdao.listarCpf();
		for(String cpf : lista) {
			assertEquals(5,lista.size());
		}
	}
	
	@Test
	void listarNomeeCpfPorCep() {
		Cliente c = cdao.listarNomeeCpfPorCep(12890000);
		
	
			assertTrue(c.getNome().equals("Julio"));
			assertTrue(c.getCpf().equals("88892992922"));
		
	}


}
