package br.com.fiap.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;


public class LivroDAOTest {
	
	private static LivroDAO dao;
	private  Livro livro;
	
	@BeforeAll
	public static void init() {
		//Instanciar os objetos
		EntityManagerFactory fabrica = 
					EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		dao = new LivroDAOImpl(em);
	}
	
	@BeforeEach
	//antes de cada teste
	public  void cadastro() {
		livro = new Livro("O nome do vento",Calendar.getInstance(),Genero.AVENTURA,1500);
		try {
		dao.cadastrar(livro);
		dao.commit();
		}catch(Exception e ) {
			e.printStackTrace();
			fail("Errrou");
		}
	}
	
	@Test

	public void buscaTest() {
		
		//pesquisa o livro cdastrado
		Livro busca = dao.buscar(livro.getCodigo());
		
		//Valuidar se deu certo
		assertNotNull(busca);
		assertEquals("O nome do vento",busca.getNome());
	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	public void cadastroTest() {

		
		//Chamar o método de cadastrar
	
		
		//Validar se deu certo
		assertNotEquals(0, livro.getCodigo());
		
	}
	
	@Test
	@DisplayName("Teste de atualizacao com sucesso")
	public void atualizar() {
		//Cadastra um livro 

		
		
		try {
			dao.atualizar(new Livro(livro.getCodigo(),"O capital",Calendar.getInstance(),Genero.FICCAO,300));
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
		//busca o livro
		Livro busca1 = dao.buscar(livro.getCodigo());
		
		//Valida se foi atualizado
		assertEquals(livro.getNumeroPaginas(),busca1.getNumeroPaginas());
		assertEquals(Genero.FICCAO,busca1.getGenero());
	}
	
	
	@Test
	@DisplayName("Teste de remocao com sucesso")
	public void remover() {
		
		
		try {
			dao.remover(livro.getCodigo());
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail();
		}
		
		//valida o resultado
		Livro busca = dao.buscar(livro.getCodigo());
		assertNull(busca);
	}
	

}




