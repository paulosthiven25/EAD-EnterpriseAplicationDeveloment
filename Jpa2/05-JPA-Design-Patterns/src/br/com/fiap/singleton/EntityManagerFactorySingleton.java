package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//atributo est�tico que possui o objeto �nico
	private static EntityManagerFactory fabrica;
	
	//construtor privado
	private EntityManagerFactorySingleton() {}
	
	//m�todo est�tico que retorna a �nica instancia
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
	
}



