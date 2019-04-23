package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_DIRETOR")
@SequenceGenerator(name = "diretor", sequenceName = "SQ_T_DIRETOR", allocationSize = 1)
public class Diretor {

	@Id
	@Column(name = "cd_diretor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diretor")
	private int codigo;

	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_escola", nullable = false)
	private Escola escola;

	@Column(name = "nm_diretor", nullable = false, length = 50)
	private String nome;

	@Column(name = "vl_salario")
	private float salario;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;
	
	public Diretor() {
		super();
	}

	public Diretor(Escola escola, String nome, float salario, Calendar dataNascimento) {
		super();
		this.escola = escola;
		this.nome = nome;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}