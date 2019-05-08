package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.PassageiroDAO;
import br.com.fiap.daoImpl.CorridaDAOImpl;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.FormaPagamento;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.entity.Passageiro;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TesteCadastro {
	
	private static MotoristaDAO mdao;
	private static PassageiroDAO pdao;
	private static CorridaDAO cdao;
	
	@BeforeAll
	public static void init () {

		cdao = new CorridaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	

	@Test
	void testarCadastro() {
		 Motorista m = new Motorista("Paulera",new GregorianCalendar(Calendar.APRIL, 12,2010), null,Genero.MASCULINO,209,1205,345609);
		 Passageiro p = new Passageiro("Jooj",new GregorianCalendar(Calendar.APRIL, 12,2002),Genero.FEMININO);
		 Corrida c=new Corrida(p, m,"Rua Cesario Alvim","Rua dos pães",40);
		 Pagamento pq =new Pagamento(500,FormaPagamento.DINHEIRO,c);
		 c.setPagamento(pq);
		 
		 try {
			cdao.cadastrar(c);
			cdao.commit();
		} catch (Exception e) {
		e.printStackTrace();
		fail();
		}
		
	}

}
