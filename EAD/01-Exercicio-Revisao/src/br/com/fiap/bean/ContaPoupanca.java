package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento{

	private float taxa;
	
	//Constante
	public static final float RENDIMENTO = 0.05f; 

	public ContaPoupanca() {}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	@Override
	public void retirar(double valor) throws Exception {
		if (saldo - valor - taxa < 0) {
			throw new Exception("Saldo insuficiente");
		}
		//setSaldo(getSaldo()-valor-taxa);
		saldo -= valor + taxa;
	}

	@Override
	public double calculaRetornoInvestimento() {
		return saldo*RENDIMENTO;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
