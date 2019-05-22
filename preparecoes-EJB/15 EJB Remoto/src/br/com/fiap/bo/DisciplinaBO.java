package br.com.fiap.bo;

import javax.ejb.Remote;

//@Local
@Remote
public interface DisciplinaBO {

	double calcularPS(double nac, double am);
	
	boolean verificarRetidoFalta(int aulas, int faltas);
	
}