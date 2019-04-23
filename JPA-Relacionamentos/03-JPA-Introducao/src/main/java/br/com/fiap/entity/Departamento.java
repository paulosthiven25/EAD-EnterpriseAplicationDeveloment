package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_DEPARTAMENTO")
@SequenceGenerator(name = "dep", sequenceName = "SQ_T_DEPARTAMENTO", allocationSize = 1)
public class Departamento {

	@Id
	@Column(name = "cd_departamento")
	@GeneratedValue(generator = "dep", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_departamento", nullable = false, length = 100)
	private String nome;

	@CreationTimestamp
	@Column(name="dt_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private Tipo tipo;
	
	@Column(name="vl_orcamento")
	private float orcamento;
	
	@Lob
	@Column(name="fl_contrato")
	private byte[] contrato;

	public Departamento(String nome, Calendar dataCriacao, Tipo tipo, float orcamento, byte[] contrato) {
		super();
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.tipo = tipo;
		this.orcamento = orcamento;
		this.contrato = contrato;
	}

	public Departamento(int codigo, String nome, Calendar dataCriacao, Tipo tipo, float orcamento, byte[] contrato) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.tipo = tipo;
		this.orcamento = orcamento;
		this.contrato = contrato;
	}

	public Departamento() {
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

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

	public byte[] getContrato() {
		return contrato;
	}

	public void setContrato(byte[] contrato) {
		this.contrato = contrato;
	}
	
}
