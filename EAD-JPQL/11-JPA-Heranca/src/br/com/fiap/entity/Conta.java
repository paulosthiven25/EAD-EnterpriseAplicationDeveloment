package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CONTA")
public class Conta {

	@Id
	@Column(name="nr_conta")
	@SequenceGenerator(name="conta", sequenceName="SQ_T_CONTA", allocationSize = 1)
	@GeneratedValue(generator = "conta", strategy = GenerationType.SEQUENCE)
	private int conta;
	
	@ManyToOne
	@JoinColumn(name="nr_agencia")
	private Agencia agencia;
	
	@Column(name="vl_saldo")
	private double saldo;
	
	public Conta() {
		super();
	}

	public Conta(Agencia agencia, double saldo) {
		super();
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
