package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.AgenciaDAO;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.AgenciaDAOImpl;
import br.com.fiap.dao.impl.ConsultaDAOImpl;
import br.com.fiap.dao.impl.ContaDAOImpl;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.Agencia;
import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.Conta;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {

	private static ConsultaDAO dao;

	private static PessoaDAO pdao;

	private static ContaDAO cdao;
	
	private static AgenciaDAO adao;
	
	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ConsultaDAOImpl(em);
		pdao = new PessoaDAOImpl(em);
		cdao=new ContaDAOImpl(em);
		adao=new AgenciaDAOImpl(em);
	}
	
	@Test
	void cadastrarTudoTest() {
		//Cadastrar o medico, paciente e consulta
		Medico medico = new Medico(123, "Drauzio", "Geral",2000,6556);
		Paciente paciente = new Paciente("Hebert", "54 5565-6655");
		Consulta consulta = new Consulta(medico, paciente, Calendar.getInstance(), "Exames de rotina");
		
		try {
			dao.cadastrar(consulta);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	@Test
	void cadastrarHerancaTest() {
		Pessoa p = new Pessoa("Guilherme");
		PessoaFisica pf = new PessoaFisica("Fernanado",Calendar.getInstance(),"12345678909");
		PessoaJuridica pj = new PessoaJuridica("FIAP", "23894784/0001-52",2000000);
		
	try {
		pdao.cadastrar(p);
		pdao.cadastrar(pf);
		pdao.cadastrar(pj);
		pdao.commit();
	} catch (CommitException e) {
		e.printStackTrace();
		fail();
	}
	}
	
	@Test
	void cadastrarTudoTestConta() {
		//Cadastrar o medico, paciente e consulta
		Agencia a = new Agencia("Rua pao de crico");
		Conta c = new Conta(a,3000); 
	
		
	
		
	}
	

}
