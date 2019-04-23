package br.com.fiap.teste;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CasoTesteDAO;
import br.com.fiap.dao.SistemaDAO;
import br.com.fiap.daoImpl.CasoTestedaoImpl;
import br.com.fiap.daoImpl.SistemadaoImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TesteCaso {
	private static CasoTesteDAO ctdao;
	private static SistemaDAO sisdao;
	
	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ctdao = new CasoTestedaoImpl(em);
		sisdao = new SistemadaoImpl(em);
	}
	
	@Test
	void cadastrar() {
		List<Usuario> usuarios = new ArrayList<>();
		Usuario u1 =new Usuario("Paulera");
		Usuario u2 =new Usuario("pao");
		usuarios.add(u1);
		usuarios.add(u2);
		
	
	
		
		Sistema s1 = new Sistema("SistemadePao");
		CasoTeste ct1 = new CasoTeste("Teste1","primeriro teste",s1);
		CasoTeste ct2 = new CasoTeste("Teste1","primeriro teste",s1);
		s1.addCasoTeste(ct1);
		s1.addCasoTeste(ct2);
		
		List<Item> itens = new ArrayList<>();
		Item i1 = new Item("pao de batata",ct1,usuarios);
		Item i2 = new Item("pao de arroz",ct1,usuarios);
		itens.add(i1);
		itens.add(i2);
		
		ct1.addItemTeste(i1);
		ct1.addItemTeste(i2);
		
		u1.setItens(itens);
	
		try {
			sisdao.cadastrar(s1);
			sisdao.commit();
		} catch (Exception e) {
		e.printStackTrace();
		fail();
		}
		


		
		
	}

}
