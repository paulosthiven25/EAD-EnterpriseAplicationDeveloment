package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(sequenceName="SQ_T_CORRIDA",name="Corre",allocationSize=1)
public class Corrida {
	@GeneratedValue(generator="Corre",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="CD_CORRIDA")
	private int codigo;
	@Column(name="DS_ORIGEM",length=150)
	private String origem;
	@Column(name="DS_DESTINO",length=150)
	private String destino;
	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	@Column(name="DT_CORRIDA")
	private Calendar data;
	@Column(name="VL_CORRIDA",nullable=false)
	private float valor;
	
	
	
	
	public Corrida() {
		super();
	}
	
	
	public Corrida(String origem, String destino, float valor) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
	}


	public Corrida(int codigo, String origem, String destino, Calendar data, float valor) {
		super();
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.valor = valor;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

}
