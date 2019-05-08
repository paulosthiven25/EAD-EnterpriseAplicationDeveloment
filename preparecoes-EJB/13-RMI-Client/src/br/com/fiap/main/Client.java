package br.com.fiap.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.fiap.BO.CalculadoraBO;

public class Client {

	public static void main(String[] args) throws Exception, RemoteException, NotBoundException {
		// Acessar o m�todo remoto
		
		CalculadoraBO bo = (CalculadoraBO) Naming.lookup("rmi://localhost:8080/calc");
		
		
		int soma = bo.somar(10,10);
		System.out.println("Soma: "+soma);
		
		
		int fatorial =bo.fatorial(6);
		System.out.println("Fatorial: "+fatorial);
		
		

	}

}
