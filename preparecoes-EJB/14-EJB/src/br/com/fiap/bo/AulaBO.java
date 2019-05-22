package br.com.fiap.bo;

import javax.ejb.Remote;


@Remote
public interface AulaBO {

	int RecuperarFaltas();
	
	void adicionarfalta();
	
}