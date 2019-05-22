package br.com.fiap.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import br.com.fiap.bo.DisciplinaBO;

@ManagedBean
public class DisciplinaBean {

	private double nac, am, ps;
	
	private int aulas, faltas;
	
	private boolean retido;
	
	@EJB
	private DisciplinaBO bo;
	
	public void verificar() {
		retido = bo.verificarRetidoFalta(aulas, faltas);
	}
	
	public void calcular() {
		ps = bo.calcularPS(nac, am);
	}

	public double getNac() {
		return nac;
	}

	public void setNac(double nac) {
		this.nac = nac;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

	public double getPs() {
		return ps;
	}

	public void setPs(double ps) {
		this.ps = ps;
	}

	public int getAulas() {
		return aulas;
	}

	public void setAulas(int aulas) {
		this.aulas = aulas;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public boolean isRetido() {
		return retido;
	}

	public void setRetido(boolean retido) {
		this.retido = retido;
	}
	
}
