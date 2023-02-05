package Ejercicio_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static List<Double> lista = new ArrayList<Double>();
	
	public static void main(String[] args) {
		
		double numero = 0;
		double sumaTotal = 0, mediaSumaTotal = 0;
		double sumaPositivo = 0, sumaNegativo = 0;
		
		while(true) {
			numero = cargarNumero();
			lista.add(numero);
			
			if(numero == -1) {
				break;
			}
			boolean esPositivo = numero > 0;
			if(esPositivo) 
				sumaPositivo+=numero;				
			else 
				sumaNegativo+=numero;
			
			sumaTotal+=numero;
			mediaSumaTotal=sumaTotal/2;
		}
		
		imprimir(sumaTotal,sumaPositivo,sumaNegativo,mediaSumaTotal);	
	}
	public static Double cargarNumero() {
		Scanner entrada = new Scanner(System.in);
		return entrada.nextDouble();
	}
	public static void imprimir(double sumaTotal,double sumaPositivo, double sumaNegativo, double mediaSumaTotal) {
		System.out.println("Maximo: "+Collections.max(lista)); //Retorna valor máximo de la colección
		System.out.println("Minimo: "+Collections.min(lista)); //Retorna valor máximo de la colección
		System.out.println("La suma de todo es: "+sumaTotal);
		System.out.println("La suma Positiva es: "+sumaPositivo);
		System.out.println("La suma Negativa es: "+sumaNegativo);
		System.out.println("La mitad de la suma total es: "+mediaSumaTotal);
	}
}
