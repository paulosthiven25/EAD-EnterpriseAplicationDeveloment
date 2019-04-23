package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Teste {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(10, 123, 
				Calendar.getInstance(), 0, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(10, 122, 
				Calendar.getInstance(), 0, 2);
		
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		
		lista.add(new ContaCorrente(10,321,
				new GregorianCalendar(1999, Calendar.JANUARY, 2),
				100, TipoConta.ESPECIAL));
		lista.add(new ContaCorrente(11,123,
				new GregorianCalendar(2010, Calendar.MARCH, 20),
				200, TipoConta.ESPECIAL));
		lista.add(new ContaCorrente(10, 222, 
				Calendar.getInstance(), 
				3000, TipoConta.PREMIUM));
		
		for (ContaCorrente item : lista) {
			System.out.println(item);
			System.out.println("*********");
		}
		
		//new Date(""); deprecated
	}
	
}






