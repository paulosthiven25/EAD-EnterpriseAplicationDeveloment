package br.com.fiap.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.fiap.entity.Hospital;

public class Desserializacao {
	 public static void main(String[] args) throws Exception {
		//Ler o arquivo e desserializar o objeto Hospital
		 FileInputStream file = new FileInputStream("saida.txt");
		 ObjectInputStream input = new ObjectInputStream(file);
		 
		 Hospital hospital  = (Hospital)input.readObject();
		 
		 System.out.println("Nome: "+hospital.getNome());
		 System.out.println("IML: "+(hospital.isIml()?"Sim":"N�o"));
		 System.out.println("Data abertuta: "+hospital.getDataAbertura().getTime());
		 
		 input.close();
		 file.close();
	}

}
