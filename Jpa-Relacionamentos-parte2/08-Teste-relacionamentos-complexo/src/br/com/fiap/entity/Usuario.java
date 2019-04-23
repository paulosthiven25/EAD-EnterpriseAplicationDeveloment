package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="PQ4",sequenceName="SQ_TAB_USUARIO",allocationSize=1)
public class Usuario {
	@GeneratedValue(generator="PQ4",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="COD_USUARIO")
	private int codigo;
	@Column(name="NOM_USUARIO")
	private String nome;
	
	@ManyToMany
	@JoinTable(name="TAB_ITEM_TESTE_USUARIO",
	joinColumns=@JoinColumn(name="COD_USUARIO"),
	inverseJoinColumns=@JoinColumn(name="COD_ITEM_TESTE"))
	private List<Item> itens;
	
	
	

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Usuario(int codigo, String nome, List<Item> itens) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.itens = itens;
	}

	public Usuario(String nome, List<Item> itens) {
		super();
		this.nome = nome;
		this.itens = itens;
	}

	public Usuario() {
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

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
     
	
}
