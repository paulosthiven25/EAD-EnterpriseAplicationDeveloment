package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_PESSOA_JURIDICA")

public class PessoaJuridica extends Pessoa {

	@Column(name="nr_cnpj")
	private double faturamento;
	@Column(name="vl_faturamento")
	private String cnpj;

	public PessoaJuridica() {
		super();
		
	}
	
	public PessoaJuridica(String nome,double faturamento, String cnpj) {
		super(nome);
		this.faturamento = faturamento;
		this.cnpj = cnpj;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
