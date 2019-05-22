package br.com.fiap.bean;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.bo.AulaBO;

@ManagedBean
@ViewScoped
public class AulaBean {
	
	@EJB
	private AulaBO bo;
	
	private int faltas;
	
	public void registrar() {
		bo.adicionarfalta();
		faltas = bo.RecuperarFaltas();
	}
	
	public int getFaltas() {
		return faltas;
	}
	

}
