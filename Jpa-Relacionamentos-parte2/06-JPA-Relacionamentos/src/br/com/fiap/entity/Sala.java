package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SALA")
@SequenceGenerator(name = "sala", sequenceName = "SQ_T_SALA", allocationSize = 1)
public class Sala {

	@Id
	@Column(name = "cd_sala")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_escola")
	private Escola escola;

	@Column(name = "nr_andar")
	private int andar;

	@Column(name = "vl_capacidade")
	private int capacidade;
	
	public Sala() {
		super();
	}


	public Sala(int andar, int capacidade) {
		super();
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
