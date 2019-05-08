package br.com.fiap.main;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.fiap.entity.Hospital;

public class Server {

	public static void main(String[] args) throws Exception {
		// Criar um ServerSocket para ler um objeto Hospital
		
		ServerSocket server = new ServerSocket(8080);
		System.out.println("Agurdando conexão..");
		Socket socket = server.accept();
		
		//socket.getInputStream();socket.getOutputStream();
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		
	Hospital hospital = (Hospital) input.readObject();
	
	 System.out.println("Nome: "+hospital.getNome());
	 System.out.println("IML: "+(hospital.isIml()?"Sim":"Não"));
	 System.out.println("Data abertuta: "+hospital.getDataAbertura().getTime());
	 
	 socket.close();
	 server.close();
	
	
	
	}

}
