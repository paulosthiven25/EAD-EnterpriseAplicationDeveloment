package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(sequenceName="SQ_T_MOTORISTA",name="motorista",allocationSize=1)
@SecondaryTable(name="T_DADOS_MOTORISTA",pkJoinColumns={@PrimaryKeyJoinColumn(name="NR_CARTEIRA")})
public class Motorista {
	@GeneratedValue(generator="motorista",strategy=GenerationType.SEQUENCE)
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
	@JoinTable(name="T_VEICULO_MOTORISTA",
	joinColumns=@JoinColumn(name="CD_MOTORISTA"),
	inverseJoinColumns=@JoinColumn(name="CD_VEICULO"))
	private List<Veiculo> veiculos=new ArrayList<>();
	
	@Column(name="NR_BANCO",table="T_DADOS_MOTORISTA",nullable=false)
	private int numeroBanco;
	
	@Column(name="NR_AGENCIA",table="T_DADOS_MOTORISTA",nullable=false)
	private int numeroAgencia;
	
	@Column(name="NR_CONTA",table="T_DADOS_MOTORISTA",nullable=false)
	private int numeroConta;
	
	public Motorista() {
		super();
	}
	

	
	
	public Motorista(String nome, Calendar dataNascimento, byte[] foto, Genero genero, int numeroBanco,
			int numeroAgencia, int numeroConta) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
		this.numeroBanco = numeroBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
	}




	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}


	

	public int getNumeroBanco() {
		return numeroBanco;
	}




	public void setNumeroBanco(int numeroBanco) {
		this.numeroBanco = numeroBanco;
	}




	public int getNumeroAgencia() {
		return numeroAgencia;
	}




	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}




	public int getNumeroConta() {
		return numeroConta;
	}




	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
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
