package br.com.fiap.revisao.bean;

//classe abstrata -> n�o pode ser instanciado 
//(base para as classes filhas)
//PODE conter m�todos abstratos (sem corpo)
public abstract class Pessoa {

	private String nome;
	
	public abstract void cadastrar();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}