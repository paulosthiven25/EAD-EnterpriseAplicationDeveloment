package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PROFESSOR")
@SequenceGenerator(sequenceName="SQ_T_PROFESSOR",name="prof",allocationSize=1)
public class Professor {
	@Id
	@GeneratedValue(generator="prof",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_PROFESSOR")
	private int codigo;
	@Column(name="NM_PROFESSOR")
	private String nome;
	@Column(name="NV_PROFESSOR")
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	
	public Professor() {
		super();
	}
	public Professor(String nome, Nivel nivel) {
		super();
		this.nome = nome;
		this.nivel = nivel;
	}
	public Professor(int codigo, String nome, Nivel nivel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nivel = nivel;
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
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
}
