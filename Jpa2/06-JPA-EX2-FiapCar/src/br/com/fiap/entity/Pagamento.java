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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="T_PAGAMENTO")
@SequenceGenerator(sequenceName="SQ_T_PAGAMENTO",name="Pagamento",allocationSize=1)

public class Pagamento {
	@GeneratedValue(generator="Pagamento",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="CD_PAGAMENTO")
	private int codigo;
	@Column(name="DT_PAGAMENTO",nullable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	private Calendar dt_pagamento;
	@Column(name="VL_PAGAMENTO",nullable=false)
	private float valor;
	@Column(name="DS_FORMA_PAGAMENTO",nullable=false)
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
	
	
	public Pagamento(float valor, FormaPagamento formaPagamento) {
		super();
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}
	public Pagamento(int codigo, Calendar dt_pagamento, float valor, FormaPagamento formaPagamento) {
		super();
		this.codigo = codigo;
		this.dt_pagamento = dt_pagamento;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}
	public Pagamento() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Calendar getDt_pagamento() {
		return dt_pagamento;
	}
	public void setDt_pagamento(Calendar dt_pagamento) {
		this.dt_pagamento = dt_pagamento;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
