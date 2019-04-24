package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_AGENCIA")
@SequenceGenerator(name = "agencia", sequenceName = "SQ_T_AGENCIA", allocationSize = 1)
public class Agencia {

	@Id
	@Column(name = "nr_agencia")
	private int nrAgencia;

	@Column(name = "ds_endereco")
	private String endereco;

	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas;
	
	public Agencia() {
		super();
	}

	public Agencia(String endereco) {
		super();
		this.endereco = endereco;
	}

	public int getNrAgencia() {
		return nrAgencia;
	}

	public void setNrAgencia(int nrAgencia) {
		this.nrAgencia = nrAgencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getConta() {
		return contas;
	}

	public void setConta(List<Conta> contas) {
		this.contas = contas;
	}

}
