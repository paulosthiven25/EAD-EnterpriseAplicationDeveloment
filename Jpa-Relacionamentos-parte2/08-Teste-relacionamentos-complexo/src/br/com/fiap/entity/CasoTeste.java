package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CASO_TESTE")
@SequenceGenerator(name="PQ1",sequenceName="SQ_TAB_CASO_TESTE",allocationSize=1)
public class CasoTeste {
	@GeneratedValue(generator="PQ1",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="COD_CASO_TESTE")
	private int codigo;
	@Column(name="NOM_CASO_TESTE")
	private String nome;
	@Column(name="DES_CASO_TESTE")
	private String descricao;
	@ManyToOne
	@JoinColumn(name="COD_SISTEMA")
	private Sistema sistema;
	
	@OneToMany(mappedBy="casoTeste")
	private List<Item> itensTeste = new ArrayList<>();
	
	
	
	
public CasoTeste(int codigo, String nome, String descricao, Sistema sistema, List<Item> itensTeste) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
		this.itensTeste = itensTeste;
	}




public CasoTeste(String nome, String descricao, Sistema sistema) {
	super();
	this.nome = nome;
	this.descricao = descricao;
	this.sistema = sistema;
}




public CasoTeste(String nome, String descricao, Sistema sistema, List<Item> itensTeste) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
		this.itensTeste = itensTeste;
	}




public CasoTeste() {
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




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public Sistema getSistema() {
		return sistema;
	}




	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}




	public List<Item> getItensTeste() {
		return itensTeste;
	}




	public void setItensTeste(List<Item> itensTeste) {
		this.itensTeste = itensTeste;
	}




public void addItemTeste(Item it) {
		
		itensTeste.add(it);
		it.setCasoTeste(this);
		
	}
	

}
