package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.FornecedorDAO;
import br.com.fiap.dao.impl.FornecedorDAOImpl;
import br.com.fiap.entity.Fornecedor;
import br.com.fiap.entity.TipoFornecedor;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		FornecedorDAO dao = new FornecedorDAOImpl(em);

		//cadastrar um fornecedor
		Fornecedor f = new Fornecedor("Ambev", 454654646, TipoFornecedor.ATACADO);
		
		try {
			dao.gravar(f);
			dao.commit();
			System.out.println("Fornecedor cadastrado!");
		} catch (CommitException e) {
			e.printStackTrace();
			System.out.println("Deu ruim");
		}
	
		//buscar um fornecedor
		Fornecedor busca = dao.pesquisar(1);
		
		//atualizar um fornecedor
		try {
			busca.setNome("Zoomo");
			dao.alterar(busca);
			dao.commit();
			System.out.println("Fornecedor atualizado!");
		} catch (CommitException e) {
			e.printStackTrace();
			System.out.println("Erro..");
		}
		
		//remover um fornecedor
		try {
			dao.remover(1);
			dao.commit();
			System.out.println("Fornecedor removido!");
		} catch (CodigoInexistenteException e) {
			System.out.println("Código inexistente");
			e.printStackTrace();
		} catch (CommitException e) {
			System.out.println("Erro no commit");
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}




