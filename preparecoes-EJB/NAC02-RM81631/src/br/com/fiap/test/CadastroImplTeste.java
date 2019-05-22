package br.com.fiap.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ItemPedidoDAO;
import br.com.fiap.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.ItemPedido;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class CadastroImplTeste {
	private static ItemPedidoDAO ipdao; 
	
	
	@BeforeAll
	public static void init () {
		ipdao = new ItemPedidoDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
		
	}

	@Test
	void cadastrarTudo() {
		Cliente c = new Cliente("Pedro",Genero.MASCULINO);
		Pedido pe = new Pedido(Calendar.getInstance());
		pe.setCliente(c);
		Produto pr = new Produto("Peixeira",null);
		
		ItemPedido ip = new ItemPedido(3,100);
		ip.setPedido(pe);
		ip.setProduto(pr);
		try {
			ipdao.cadastrar(ip);
			ipdao.commit();
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
	}

}
