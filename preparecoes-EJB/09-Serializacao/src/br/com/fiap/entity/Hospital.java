package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

public class Hospital implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2172083850254111624L;

	private String nome;
	
	private boolean iml;
	
	private Calendar dataAbertura;

	public Hospital() {
		super();
	}

	public Hospital(String nome, boolean iml, Calendar dataAbertura) {
		super();
		this.nome = nome;
		this.iml = iml;
		this.dataAbertura = dataAbertura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isIml() {
		return iml;
	}

	public void setIml(boolean iml) {
		this.iml = iml;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
}
