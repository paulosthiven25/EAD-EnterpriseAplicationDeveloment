package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PASSAGEIRO")
@SequenceGenerator(sequenceName="SQ_T_PASSAGEIRO",name="passageiro",allocationSize=1)
public class Passageiro {
	@GeneratedValue(generator="passageiro",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="CD_PASSAGEIRO")
	private int codigo;
	@Column(name="NM_PASSAGEIRO",nullable=false)
	private String nome;
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	@Column(name="DS_GENERO")
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	
	@OneToMany(mappedBy="passageiro")
	private List<Corrida> corridas = new ArrayList<>();
	

	
	
	
	public List<Corrida> getCorridas() {
		return corridas;
	}



	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}



	public Passageiro() {
		super();
	}
	
	
	
	public Passageiro(String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}



	public Passageiro(int codigo, String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	

}
