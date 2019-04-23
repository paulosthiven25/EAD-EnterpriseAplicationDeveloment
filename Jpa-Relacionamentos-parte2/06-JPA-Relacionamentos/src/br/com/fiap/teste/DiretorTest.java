package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.DiretorDAO;
import br.com.fiap.dao.EscolaDAO;
import br.com.fiap.dao.impl.DiretorDAOImpl;
import br.com.fiap.dao.impl.EscolaDAOImpl;
import br.com.fiap.entity.Diretor;
import br.com.fiap.entity.Escola;
import br.com.fiap.entity.Formacao;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.Sala;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class DiretorTest {

	private static DiretorDAO diretorDao;
	private static EscolaDAO escolaDao;

	private Escola escola;
	private Diretor diretor;

	@BeforeEach
	public void cadastrar() {
		// Cadastrar a escola e o diretor relacionados
		escola = new Escola( null, "Test School", true);
		diretor = new Diretor(escola, "Rodrigo", 1000, new GregorianCalendar(1998, Calendar.APRIL, 2));
		
		
		Sala sala1 = new Sala(301, 20);
		Sala sala2 = new Sala(304, 40);
		
		escola.addSala(sala1);
		escola.addSala(sala2);
		
		Professor prof1 = new Professor("Barcelos", Formacao.MESTRADO);
		Professor prof2 = new Professor("Salvio" , Formacao.ESPECIALIZACAO);
		
		List<Professor> professores = new ArrayList<>();
		professores.add(prof1);
		professores.add(prof2);
		
		escola.setProfessores(professores);
		
		try {
			//escolaDao.cadastrar(escola);
			diretorDao.cadastrar(diretor);
			diretorDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		diretorDao = new DiretorDAOImpl(em);
		escolaDao = new EscolaDAOImpl(em);
	}

	@Test
	void cadastro() {

		assertNotEquals(escola.getCodigo(), 0);
		assertNotEquals(diretor.getCodigo(), 0);

	}
	
	@Test
	void buscar() {
		
		try {
			Diretor busca = diretorDao.buscar(diretor.getCodigo());
			
			assertEquals("Rodrigo", busca.getNome());
			
			assertNotNull(busca.getEscola());
			
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		
	}

}
