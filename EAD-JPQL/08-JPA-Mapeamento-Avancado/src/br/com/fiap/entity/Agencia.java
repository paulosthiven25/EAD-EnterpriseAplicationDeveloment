package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_AGENCIA")
@SequenceGenerator(name="agencia",sequenceName="SQ_T_AGENTE",allocationSize=1)
public class Agencia {
	@Id
	@Column(name="NR_AGENCIA")
	@GeneratedValue(generator="agencia",strategy=GenerationType.SEQUENCE)
	private int numero;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	@OneToMany(mappedBy="agencia")
	private List<Conta> contas;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Agencia() {
		super();
	}
	
	

	public Agencia(int numero, String endereco) {
		super();
		this.numero = numero;
		this.endereco = endereco;
	}

	public Agencia(String endereco) {
	this.endereco=endereco;
	}
	
	
}
