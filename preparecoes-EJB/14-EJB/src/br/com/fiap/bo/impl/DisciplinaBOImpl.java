package br.com.fiap.bo.impl;

import javax.ejb.Stateless;

import br.com.fiap.bo.DisciplinaBO;

@Stateless
public class DisciplinaBOImpl implements DisciplinaBO {

	@Override
	public double calcularPS(double nac, double am) {
		return (6 - (nac * 0.2 + am * 0.3)) * 2;
	}

	@Override
	public boolean verificarRetidoFalta(int aulas, int faltas) {
		return faltas > aulas*0.25;
	}

}