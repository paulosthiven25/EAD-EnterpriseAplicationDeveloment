package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * T_FORNECEDOR (Sequence SQ_T_FORNECEDOR) 
 * 		*cd_fornecedor (NUMBER) (PK) 
 * 		*nm_fornecedor (VARCHAR(100)) 
 * 		*nr_cnpj 
 * 		dt_registro 
 * 		ds_tipo (VARCHAR) (Enum ATACADO, VAREJO)
 *
 */
@Entity
@Table(name = "T_FORNECEDOR")
@SequenceGenerator(name = "forn", sequenceName = "SQ_T_FORNECEDOR", allocationSize = 1)
public class Fornecedor {

	@Id
	@Column(name = "cd_fornecedor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forn")
	private int codigo;

	@Column(name = "nm_fornecedor", nullable = false, length = 100)
	private String nome;

	@Column(name = "nr_cnpj", nullable = false)
	private long cnpj;

	@CreationTimestamp
	@Column(name="dt_registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataRegistro;
	
	@Column(name="ds_tipo")
	@Enumerated(EnumType.STRING)
	private TipoFornecedor tipo;
	
	public Fornecedor() {
		super();
	}
	
	public Fornecedor(int codigo, String nome, long cnpj, TipoFornecedor tipo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.tipo = tipo;
	}

	public Fornecedor(String nome, long cnpj, TipoFornecedor tipo) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.tipo = tipo;
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

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public TipoFornecedor getTipo() {
		return tipo;
	}

	public void setTipo(TipoFornecedor tipo) {
		this.tipo = tipo;
	}
	
}




