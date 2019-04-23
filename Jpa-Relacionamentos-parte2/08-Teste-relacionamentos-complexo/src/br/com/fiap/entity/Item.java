package br.com.fiap.entity;

import java.util.List;

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
@Table(name="TAB_ITEM_TESTE")
@SequenceGenerator(name="PQ3",sequenceName="SQ_TAB_ITEM_TESTE",allocationSize=1)
public class Item {
	@GeneratedValue(generator="PQ3",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="COD_ITEM_TESTE")
	private int codigo;
	@Column(name="DES_ITEM_TESTE")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="COD_CASO_TESTE")
	private CasoTeste casoTeste;
	
	@ManyToMany(mappedBy="itens")
	private List<Usuario> usuarios;
	
	
	

	public Item(int codigo, String descricao, CasoTeste casoTeste, List<Usuario> usuarios) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.casoTeste = casoTeste;
		this.usuarios = usuarios;
	}

	public Item(String descricao, CasoTeste casoTeste, List<Usuario> usuarios) {
		super();
		this.descricao = descricao;
		this.casoTeste = casoTeste;
		this.usuarios = usuarios;
	}

	public Item() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
