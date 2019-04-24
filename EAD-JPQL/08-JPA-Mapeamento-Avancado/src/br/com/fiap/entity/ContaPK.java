package br.com.fiap.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContaPK implements Serializable {

	private int codigo;
	private int agencia;
	private int conta;
	public ContaPK() {
		super();
	}
	public ContaPK(int codigo, int agencia, int conta) {
		super();
		this.codigo = codigo;
		this.agencia = agencia;
		this.conta = conta;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + codigo;
		result = prime * result + conta;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPK other = (ContaPK) obj;
		if (agencia != other.agencia)
			return false;
		if (codigo != other.codigo)
			return false;
		if (conta != other.conta)
			return false;
		return true;
	}
	
	
}
