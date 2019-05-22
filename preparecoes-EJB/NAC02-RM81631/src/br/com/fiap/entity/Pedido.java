package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="T_NAC_PEDIDO")
@SequenceGenerator(name = "pedido",sequenceName="SQ_NAC_PEDIDO",allocationSize=1) 
public class Pedido {
	@GeneratedValue(generator="pedido",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="CD_PEDIDO")
	private int codigo;
	@Column(name="DT_PEDIDO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataPedido;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_CLIENTE",nullable=false)
	private Cliente cliente;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itensPedidos = new ArrayList<>();
	
	
	
	
	public Pedido(Calendar dataPedido) {
		super();
		this.dataPedido = dataPedido;
	}
	public Pedido() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}
	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
	
	
	
}
