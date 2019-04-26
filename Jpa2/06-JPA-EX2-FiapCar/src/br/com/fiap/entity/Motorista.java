package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_MOTORISTA")

public class Motorista {

	@Id
	@Column(name="NR_CARTEIRA")
	private int codigo;
	@Column(name="NM_MOTORISTA",nullable=false,length=150)
	private String nome;
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	@Column(name="FL_CARTEIRA")
	@Lob
	private byte[] foto;
	@Column(name="DS_GENERO")
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@OneToMany(mappedBy="motorista")
	private List<Corrida> corridas = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(name="T_PACOTE_CLIENTE",
	joinColumns=@JoinColumn(name="CD_MOTORISTA"),
	inverseJoinColumns=@JoinColumn(name="CD_VEICULO"))
	private List<Veiculo> veiculos=new ArrayList<>();
	
	
	
	public Motorista() {
		super();
	}
	
	public Motorista(String nome, Calendar dataNascimento, byte[] foto, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
	}
	
	

	public Motorista(int codigo, String nome, Calendar dataNascimento, byte[] foto, Genero genero) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	

}
