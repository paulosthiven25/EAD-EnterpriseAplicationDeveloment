package br.com.fiap.entity;

import javax.persistence.Entity;

import javax.persistence.Table;


@Entity
@Table(name="T_PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{
	private String cnpj;
	private double faturamneto;
	
	
	public PessoaJuridica(String nome,String cnpj, double faturamneto) {
		super(nome);
		this.cnpj = cnpj;
		this.faturamneto = faturamneto;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public double getFaturamneto() {
		return faturamneto;
	}


	public void setFaturamneto(double faturamneto) {
		this.faturamneto = faturamneto;
	}


	public PessoaJuridica() {
		super();
	}
	
	
	
	
}
