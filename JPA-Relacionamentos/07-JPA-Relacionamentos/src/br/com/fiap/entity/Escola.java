package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ESCOLA")
@SequenceGenerator(sequenceName="SQ_T_ESCOLA",name="escola",allocationSize=1)
public class Escola {
	@Id
	@GeneratedValue(generator="escola",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_ESCOLA")
  private int codigo;
	
	@OneToMany(mappedBy="escola")
	private List<Sala> salas;
	
	//mappedBy nome do ATRIBUTO QUE MAPEIA A fk NA CLASSE DIRETOR
	@OneToOne(mappedBy="escola")
	private Diretor diretor;
	@Column(name="NM_ESCOLA")
  private String nome;
	@Column(name="ST_ESCOLA")
  private boolean particular;
	
	
	
	public Escola() {
		super();
	}
	public Escola(List<Sala> salas, Diretor diretor, String nome, boolean particular) {
		super();
		this.salas = salas;
		this.diretor = diretor;
		this.nome = nome;
		this.particular = particular;
	}
	public Escola(int codigo, List<Sala> salas, Diretor diretor, String nome, boolean particular) {
		super();
		this.codigo = codigo;
		this.salas = salas;
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
