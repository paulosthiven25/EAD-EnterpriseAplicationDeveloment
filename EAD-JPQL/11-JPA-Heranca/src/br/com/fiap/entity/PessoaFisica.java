package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PESSOA_FISICA")
@SequenceGenerator(name = "pessoa_fisica", sequenceName = "SQ_T_PESSOA_FISICA", allocationSize = 1)
public class PessoaFisica extends Pessoa {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNasc;
	@Column(name="ds_cpf")
	private String cpf;
	
	public PessoaFisica(String nome,Calendar dataNasc, String cpf) {
		super(nome);
		this.dataNasc = dataNasc;
		this.cpf = cpf;
	}

	public PessoaFisica() {
		super();
		
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
