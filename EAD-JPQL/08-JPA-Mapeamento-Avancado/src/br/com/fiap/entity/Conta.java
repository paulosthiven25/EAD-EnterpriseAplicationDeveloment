package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CONTA")

public class Conta {
	@Id
	@Column(name="NR_CONTA")
	@GeneratedValue(generator="agencia",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="conta",sequenceName="SQ_T_CONTA",allocationSize=1)
	private int numeroConta;
	
	@ManyToOne
	private Agencia agencia;
	
	@Column(name="vl_sald0")
	private double saldo;

	public Conta(Agencia agencia, double saldo) {
		super();
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public Conta(int numeroConta, Agencia agencia, double saldo) {
		super();
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public Conta() {
		super();
	}
	
	

}
