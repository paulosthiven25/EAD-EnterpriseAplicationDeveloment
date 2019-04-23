package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Anota��o estar� presente at� a execu��o
@Retention(RetentionPolicy.RUNTIME) 
//Onde � poss�vel colocar a anota��o
@Target(ElementType.FIELD)
public @interface Coluna {

	String nome();
	boolean obrigatorio();
	
}