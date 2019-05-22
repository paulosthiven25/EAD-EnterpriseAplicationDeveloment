package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.ItemPedido;
import br.com.fiap.entity.Pedido;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TestePedido {
	
	private static ItemPedido ip; 
	private static PedidoDAO pdao;
	private static ClienteDAO cdao;
	
	@BeforeAll
	public static void init() {
		pdao = new PedidoDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
		cdao = new ClienteDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}

	@Test
	void test() {
		List<Cliente> lista = cdao.buscapordata(new GregorianCalendar(2019, Calendar.JANUARY,1), new GregorianCalendar(2019, Calendar.DECEMBER,1));
		
		assertNotEquals(0,lista.size());
	}
	
	@Test
	void contarPorCliente() {
		long qtd = pdao.contarPedidosporCliente(3);
		assertEquals(1,qtd);
	}

}
