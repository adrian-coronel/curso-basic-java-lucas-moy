package com.mycompany.sistemapersona.models;

public class Persona {
	
	private String nombre = "";
	private int edad = 0;
	private String dni;
	private char sexo;
	private double altura = 0;
	private double peso = 0;
	
	public Persona() {
		generarDni();
		comprobarSexso(sexo);
	}
	public Persona(String nombre, int edad, char sexo) {
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setSexo(sexo);
		comprobarSexso(this.sexo);
		generarDni();
	}
	public Persona(String nombre, int edad, char sexo,double altura,double peso) {
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setSexo(sexo);
		this.setAltura(altura);
		this.setPeso(peso);
		comprobarSexso(this.sexo);
		generarDni();
	}
	
	//Methods getter and setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		comprobarSexso(sexo);
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	private void comprobarSexso(char sexo) {
		if(sexo != 72) { //Los caracteres almacenan numeros y estos numeros representan a una letra
			this.sexo = 72;
		}
	}
	
	
	private void generarDni() {
		String valorDado = "7"+(int)Math.floor(Math.random()*9999999+1);
		this.dni = valorDado;
	}
	
	@Override
	public String toString() {
		return "Persona [\nnombre=" + nombre + "\n, edad=" + edad + "\n, dni=" + dni + "\n, sexo=" + sexo + "\n, altura=" + altura
				+ "\n, peso=" + peso + "\n";
	}

}
