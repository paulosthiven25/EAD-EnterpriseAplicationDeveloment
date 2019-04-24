package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PESSOA_FISICA")
public class PessoaFisica extends Pessoa {
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	private String cpf;
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public PessoaFisica(String nome,Calendar dataNascimento, String cpf) {
		super(nome);
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}
	public PessoaFisica(int codigo, String nome) {
		super(codigo, nome);
	}
	public PessoaFisica() {
		super();
	}
	
	
	
	

}
