package br.com.fiap.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CorridaPK implements Serializable {
	
	private int codigo;
	private int passageiro;
	private int motorista;
	
	
	
	
	public CorridaPK() {
		super();
	}
	public CorridaPK(int codigo, int passageiro, int motorista) {
		super();
		this.codigo = codigo;
		this.passageiro = passageiro;
		this.motorista = motorista;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + motorista;
		result = prime * result + passageiro;
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
		CorridaPK other = (CorridaPK) obj;
		if (codigo != other.codigo)
			return false;
		if (motorista != other.motorista)
			return false;
		if (passageiro != other.passageiro)
			return false;
		return true;
	}
	
	
	
	

}
