package br.com.fiap.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import br.com.fiap.entity.Hospital;

public class Serialização {

	public static void main(String[] args) throws IOException {
		// Serializar um objeto para um arquivo
		
		Hospital hospital=new Hospital("Fiap",false,Calendar.getInstance());
		
		FileOutputStream file = new FileOutputStream("saida.txt");
		ObjectOutputStream outut = new ObjectOutputStream(file);
		
		outut.writeObject(hospital);
		
		System.out.println("Serializado");
		
		
		outut.close();
		file.close();
		
		
		

	}

}
