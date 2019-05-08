package br.com.fiap.main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;

import br.com.fiap.entity.Hospital;

public class Cliente {

	public static void main(String[] args) throws Exception{
		// Serializar um objeto Hospital na rede
		
		Socket socket = new Socket("10.20.82.41",8080);
		Hospital hospital=new Hospital("Lula Livre",true,Calendar.getInstance());
		
			ObjectOutputStream output= new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(hospital);
			output.close();
			System.out.println("Serializado o hospital na rede");
			
			output.close();
			socket.close();

	}

}
