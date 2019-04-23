package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_SALA")
@SequenceGenerator(sequenceName="SQ_T_SALA",name="sala",allocationSize=1)
public class Sala {
	@Id
	@GeneratedValue(generator="sala",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_SALA")
	private int codigo;
	@ManyToOne
	@JoinColumn(name="cd_escola")
	private Escola escola;
	
	@Column(name="NR_ANDAR")
	private int andar;
	@Column(name="QT_CAPACIDADE")
	private int capacidade;
	
	
	public Sala() {
		super();
	}
	public Sala(Escola escola, int andar, int capacidade) {
		super();
		this.escola = escola;
		this.andar = andar;
		this.capacidade = capacidade;
	}
	public Sala(int codigo, Escola escola, int andar, int capacidade) {
		super();
		this.codigo = codigo;
		this.escola = escola;
		this.andar = andar;
		this.capacidade = capacidade;
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
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	
	

}
