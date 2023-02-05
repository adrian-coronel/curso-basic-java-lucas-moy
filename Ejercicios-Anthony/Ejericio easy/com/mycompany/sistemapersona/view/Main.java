package com.mycompany.sistemapersona.view;

import com.mycompany.sistemapersona.models.Persona;

import java.util.Scanner;

import com.mycompany.sistemapersona.dao.PersonaDao;
public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese su nombre");
		String nombre = s.next();
		
		System.out.println("Ingrese su edad");
		Integer edad = s.nextInt();
		
		System.out.println("Ingrese su sexo");
		char sexo = s.next().charAt(0);
		
		System.out.println("Ingrese su peso");
		double peso = s.nextDouble();
		
		System.out.println("Ingrese su altura");
		double altura = s.nextDouble();
		
		/*----- PRIMER OBJETO ------*/
		Persona persona = new Persona(nombre,edad,sexo,peso,altura);
		System.out.println(persona.toString() +", estado de peso: "+ PersonaDao.comprobarPeso(persona)+ "\n, Es mayor de edad: "+ PersonaDao.esMayorDeEdad(persona)+" ]\n\n");
		
		/*----- SEGUNDO OBJETO ------*/
		Persona persona2 = new Persona("Leonardo",16,(char)72);
		System.out.println(persona2.toString() +", estado de peso: "+ PersonaDao.comprobarPeso(persona2)+ "\n, Es mayor de edad: "+ PersonaDao.esMayorDeEdad(persona2)+" ]\n\n");
		
		/*----- TERCER OBJETO ------*/
		Persona persona3 = new Persona();
		PersonaDao.ingresarDatos(persona3);
		System.out.println(persona3.toString() +", estado de peso: "+ PersonaDao.comprobarPeso(persona3)+ "\n, Es mayor de edad: "+ PersonaDao.esMayorDeEdad(persona3)+" ]\n\n");
	}

}
