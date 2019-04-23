package br.com.fiap.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="T_FUNCIONARIO")
@SequenceGenerator(name="func",sequenceName="SQ_T_FUNCIONARIO", allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator="func", strategy=GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="nm_funcionario", nullable = false, length = 50)
	private String nome;
	
	@Column(name="vl_salario")
	private float salario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_admissao")
	private Calendar dataAdmissao;
	
	@CreationTimestamp//preenche automáticamente a data de cadastro
	@Column(name="dt_cadastro", updatable = false)
	private Calendar dataCadastro;
	
	@Transient //não será mapeado como coluna na tabela
	private int tempoDeCasa;

	@Lob //grava arquivo no banco
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_nivel")
	@Enumerated(EnumType.STRING)
	private Nivel nivel;

	public Funcionario() {
		super();
	}

	public Funcionario(int codigo, String nome, float salario, Calendar dataAdmissao,
			byte[] foto, Nivel nivel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.foto = foto;
		this.nivel = nivel;
	}

	public Funcionario(String nome, float salario, Calendar dataAdmissao, byte[] foto,
			Nivel nivel) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.foto = foto;
		this.nivel = nivel;
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getTempoDeCasa() {
		return tempoDeCasa;
	}

	public void setTempoDeCasa(int tempoDeCasa) {
		this.tempoDeCasa = tempoDeCasa;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return 	"Nome: " + nome + "\n" +
				"Salário: " + salario + "\n" +
				"Nível: " + nivel + "\n" +
				"Data admissão: " + sdf.format(dataAdmissao.getTime()) + "\n" +
				"Data cadastro: " + sdf.format(dataCadastro.getTime()) + "\n";
	}
	
}









