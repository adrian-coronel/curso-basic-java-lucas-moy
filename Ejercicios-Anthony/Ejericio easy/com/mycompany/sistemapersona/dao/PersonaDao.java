package com.mycompany.sistemapersona.dao;
import java.util.Scanner;

import com.mycompany.sistemapersona.models.Persona;

public class PersonaDao {
	
	public static void ingresarDatos(Persona persona) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese su nombre");
		persona.setNombre(s.next());
		
		System.out.println("Ingrese su edad");
		persona.setEdad(s.nextInt());
		
		System.out.println("Ingrese su sexo");
		persona.setSexo(s.next().charAt(0));
		
		System.out.println("Ingrese su peso");
		persona.setPeso(s.nextDouble());
		
		System.out.println("Ingrese su altura");
		persona.setAltura(s.nextDouble());
	}
	
	
	public static int calcularIMC(Persona persona) {
		
		double peso = persona.getPeso();
		double altura = persona.getAltura();
		
		double pesoIdeal = (peso/(Math.pow(altura, 2)));
		if(pesoIdeal < 20) {
			return -1;
		}else if(pesoIdeal >= 20 && pesoIdeal<=25) {
			return 0;
		}
		return 1;
	}
	
	public static boolean esMayorDeEdad(Persona persona) {
		if(persona.getEdad()>=18){
			return true;
		}
		return false;
	}
	
	public static String comprobarPeso(Persona persona) {
		if(calcularIMC(persona) == 0) {
			return "Esta por debajo de su peso ideal";
		}
		else if (calcularIMC(persona) == 1) {
			return "Tiene sobrepeso";
		}
		return "Su peso es ideal";
	}
 
}
