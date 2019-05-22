package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC_CLIENTE")
@SequenceGenerator(name = "cliente",sequenceName="SQ_NAC_CLIENTE",allocationSize=1) 
public class Cliente {
	@GeneratedValue(generator="cliente",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="CD_CLIENTE")
	private int codigo;
	@Column(name="NM_CLIENTE",nullable=false,length=50)
	private String nome;
	@Column(name="DS_GENERO",nullable=false)
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	

	public Cliente(String nome, Genero genero) {
		super();
		this.nome = nome;
		this.genero = genero;
	}

	public Cliente() {
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
	
}
