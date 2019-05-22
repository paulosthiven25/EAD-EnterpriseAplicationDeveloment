package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC_PRODUTO")
@SequenceGenerator(name = "produto",sequenceName="SQ_NAC_PRODUTO",allocationSize=1) 
public class Produto {
	@GeneratedValue(generator="produto",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="CD_PRODUTO")
	private int codigo;
	@Column(name="NM_PRODUTO",length=30,nullable=false)
	private String nome;
	
	@Lob
	@Column(name="FL_PRODUTO")
	private byte[] foto;
	
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itensPedidos = new ArrayList<>();
	
	

	public Produto(String nome, byte[] foto) {
		super();
		this.nome = nome;
		this.foto = foto;
	}

	public Produto() {
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
	
	

}
