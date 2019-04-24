package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.AgenciaDAO;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.AgenciaDAOImpl;
import br.com.fiap.dao.impl.ContaDAOImpl;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.Agencia;
import br.com.fiap.entity.Conta;
/*import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Paciente;*/
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	
	private static PessoaDAO pessoaDao;
	private static AgenciaDAO agenciaDao;
	private static ContaDAO contaDao;

	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		pessoaDao = new PessoaDAOImpl(em);
		agenciaDao = new AgenciaDAOImpl(em);
		contaDao = new ContaDAOImpl(em);
	}
	
	
	@Test
	void cadastrarTudo() {
		Agencia agencia = new Agencia("Rua do Limoeiro");
		Conta conta = new Conta(agencia,5000);
		
		try {
			agenciaDao.cadastrar(agencia);
			contaDao.cadastrar(conta);
			contaDao.commit();
			agenciaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void cadastrarHerancaTest() {
		Pessoa pessoa = new Pessoa("Ygor");
		PessoaFisica pf = new PessoaFisica("ABCD", Calendar.getInstance(), "12035758");
		PessoaJuridica pj = new PessoaJuridica("FIAP", 123456, "0214652/52-1");

		try {
			pessoaDao.cadastrar(pessoa);
			pessoaDao.cadastrar(pf);
			pessoaDao.cadastrar(pj);
			pessoaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail();
		}
	}
}
