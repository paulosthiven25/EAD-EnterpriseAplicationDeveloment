package br.com.fiap.bo.impl;

import javax.ejb.Singleton;

import br.com.fiap.bo.AulaBO;

@Singleton
public class AulaBOImpl implements AulaBO {
	private int faltas;
	
	@Override
	public int RecuperarFaltas() {
		return faltas;
	}

	@Override
	public void adicionarfalta() {
		faltas++;
	}



}
