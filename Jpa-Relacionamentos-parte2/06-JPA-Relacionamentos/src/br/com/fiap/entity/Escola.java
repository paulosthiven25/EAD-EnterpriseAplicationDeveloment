package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_ESCOLA")
@SequenceGenerator(name = "escola", sequenceName = "SQ_T_ESCOLA", allocationSize = 1)
public class Escola {

	@Id
	@Column(name = "cd_escola")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escola")
	private int codigo;
	
	@ManyToMany
	@JoinTable(name="T_ESCOLA_PROFESSOR", 
	joinColumns = @JoinColumn(name="cd_escola"),
	inverseJoinColumns = @JoinColumn(name="cd_professor"))
	private List<Professor> professores;
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@OneToMany(mappedBy="escola", cascade = CascadeType.ALL)
	private List<Sala> salas = new ArrayList<>();;
	
	//mappedBy nome do atributo que mapeia a FK na classe diretor
	@OneToOne(mappedBy="escola")
	private Diretor diretor;

	@Column(name = "nm_escola", nullable = false, length = 100)
	private String nome;

	@Column(name = "st_particular")
	private boolean particular;
	
	
	public void addSala(Sala sala) {
		
		salas.add(sala);
		sala.setEscola(this);
		
	}

	public Escola() {
		super();
	}

	public Escola( Diretor diretor, String nome, boolean particular) {
		super();
		this.diretor = diretor;
		this.nome = nome;
		this.particular = particular;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isParticular() {
		return particular;
	}

	public void setParticular(boolean particular) {
		this.particular = particular;
	}

}
