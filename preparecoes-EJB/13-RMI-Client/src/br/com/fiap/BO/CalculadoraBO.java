package br.com.fiap.BO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraBO extends Remote {
	
	int somar(int i,int j) throws RemoteException;
	int fatorial(int i)throws RemoteException;

}
