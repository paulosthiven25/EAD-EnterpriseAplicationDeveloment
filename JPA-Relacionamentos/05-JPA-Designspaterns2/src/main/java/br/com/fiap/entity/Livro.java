package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_LIVRO")
@SequenceGenerator(name="livro",sequenceName="SQ_T_LIVRO",allocationSize=1)

public class Livro {
	@Id
	@Column(name="cd_livro")
	@GeneratedValue(generator="livro",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_livro",nullable=false,length=100)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_publicacao")
	private Calendar dataPublicacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	
	@Column(name="nr_paginas")
	private int numeroPaginas;
	
	


	public Livro() {
		super();
	}
	
	
	public Livro(int codigo, String nome, Calendar dataPublicacao, Genero genero, int numeroPaginas) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataPublicacao = dataPublicacao;
		this.genero = genero;
		this.numeroPaginas = numeroPaginas;
	}
	
	


	public Livro(String nome, Calendar dataPublicacao, Genero genero, int numeroPaginas) {
		super();
		this.nome = nome;
		this.dataPublicacao = dataPublicacao;
		this.genero = genero;
		this.numeroPaginas = numeroPaginas;
	}


	public Livro(String nome, Genero genero, int numeroPaginas) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.numeroPaginas = numeroPaginas;
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


	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}


	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public int getNumeroPaginas() {
		return numeroPaginas;
	}


	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}


}
