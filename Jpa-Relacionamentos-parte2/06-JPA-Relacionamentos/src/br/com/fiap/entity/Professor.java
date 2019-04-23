package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PROFESSOR")
@SequenceGenerator(name = "prof", sequenceName = "SQ_T_PROFESSOR", allocationSize = 1)
public class Professor {

	@Id
	@Column(name = "cd_professor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prof")
	private int codigo;
	
	@ManyToMany(mappedBy="professores")
	private List<Escola> escolas;

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	@Column(name = "nm_professor", nullable = false, length = 100)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_formacao")
	private Formacao formacao;

	public Professor(String nome, Formacao formacao) {
		super();
		this.nome = nome;
		this.formacao = formacao;
	}

	public Professor() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

}
