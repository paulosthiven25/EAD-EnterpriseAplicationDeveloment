package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@SuppressWarnings("serial")
@Entity
@Table(name="T_CORRIDA")
@IdClass(CorridaPK.class)

public class Corrida implements Serializable{
	
	
	@Id
	@SequenceGenerator(sequenceName="SQ_T_CORRIDA",name="Corre",allocationSize=1)
	@GeneratedValue(generator="Corre",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_CORRIDA")
	private int codigo;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_PASSAGEIRO")
	private Passageiro passageiro;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_MOTORISTA")
	private Motorista motorista;
	
	@OneToMany(mappedBy="corrida")
	private List<Pagamento> pagamentos=new ArrayList<>();
	
	
	@Column(name="DS_ORIGEM",length=150)
	private String origem;
	@Column(name="DS_DESTINO",length=150)
	private String destino;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="DT_CORRIDA")
	private Calendar data;
	@Column(name="VL_CORRIDA",nullable=false)
	private float valor;
	
	
	

	
	
	
	
	
	public Corrida(Passageiro passageiro, Motorista motorista, String origem, String destino, float valor) {
		super();
		this.passageiro = passageiro;
		this.motorista = motorista;
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
	}





	public Corrida() {
		super();
	}
	
	
	


	public Passageiro getPassageiro() {
		return passageiro;
	}





	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}





	public Motorista getMotorista() {
		return motorista;
	}





	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}





	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

}
