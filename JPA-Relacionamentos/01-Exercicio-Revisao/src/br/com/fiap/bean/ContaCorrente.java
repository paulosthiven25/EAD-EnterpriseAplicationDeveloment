package br.com.fiap.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ContaCorrente extends Conta {

	private TipoConta tipo;

	public ContaCorrente() {}
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	@Override
	public void retirar(double valor) throws Exception {
		if (saldo - valor < 0 && tipo == TipoConta.COMUM) {
			throw new Exception("Saldo insuficiente");
		}
		// setSaldo(getSaldo()-valor);
		saldo -= valor;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return 	"Número: " + getNumero() + "\n" +
				"Agencia: " + getAgencia() + "\n" +
				"Tipo Conta: " + tipo + "\n" +
				"Saldo: " + saldo + "\n" +
				"Data abertura: " + 
					sdf.format(getDataAbertura().getTime()); 
	}

}







