package br.com.fiap.dao;



import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;


import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fiap.dao.exception.CommitException;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Livro;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class LivroDAOTest {
	private static LivroDao dao;
	
	@BeforeClass
	public static void init() {
		//Instanciar os objetos
				EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
				EntityManager em = fabrica.createEntityManager();
				dao = new LivroDAOImpl(em);
	}
	
	@Test
	public void buscaTest() {
	
		Livro l =dao.buscar(1);
        fail();
	
	}


	/*	@Test
	 * public void cadastroTest() {
		
		//Chamar de cadastrar
		
		Livro l = new Livro("Harry Potter",Calendar.getInstance(),Genero.FILOSOFIA,500);
		try {
			dao.cadastrar(l);
			dao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		//Validar se deu certo
		assertNotEquals(0,l.getCodigo());
	}*/

}
