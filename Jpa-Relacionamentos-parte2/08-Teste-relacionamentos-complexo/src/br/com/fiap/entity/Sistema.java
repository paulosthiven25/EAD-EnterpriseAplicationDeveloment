package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="PQ2",sequenceName="SQ_TAB_SISTEMA",allocationSize=1)
public class Sistema {
	@GeneratedValue(generator="PQ2",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="COD_SISTEMA")
	private int codigo;
	@Column(name="NOM_SISTEMA")
	private String nome;
	
	@OneToMany(mappedBy="sistema")
	private List<CasoTeste> casoTeste= new ArrayList<>();
	
public void addCasoTeste(CasoTeste ct) {
		
		casoTeste.add(ct);
		ct.setSistema(this);
		
	}





public Sistema(String nome) {
	super();
	this.nome = nome;
}





public Sistema(int codigo, String nome, List<CasoTeste> casoTeste) {
	super();
	this.codigo = codigo;
	this.nome = nome;
	this.casoTeste = casoTeste;
}





public Sistema(String nome, List<CasoTeste> casoTeste) {
	super();
	this.nome = nome;
	this.casoTeste = casoTeste;
}





public Sistema() {
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

public List<CasoTeste> getCasoTeste() {
	return casoTeste;
}

public void setCasoTeste(List<CasoTeste> casoTeste) {
	this.casoTeste = casoTeste;
}



	
}
