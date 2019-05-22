package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@IdClass(value=ItemPedidoPK.class)
@Entity

@Table(name="T_NAC_ITEM_PEDIDO")
public class ItemPedido {
	@Column(name="QT_ITEM")
	private int quantidade;
	@Column(name="VT_ITEM")
	private double valor;
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_PEDIDO",nullable=false)
	private Pedido pedido;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_PRODUTO",nullable=false)
	private Produto produto;
	
	
	

	public ItemPedido(int quantidade, double valor, Pedido pedido, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
		this.pedido = pedido;
		this.produto = produto;
	}

	public ItemPedido(int quantidade, double valor) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public ItemPedido() {
		super();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
