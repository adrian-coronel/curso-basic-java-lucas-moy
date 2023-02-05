package Bucles;

import java.util.ArrayList;
import java.util.List;

public class For {

	public static void main(String[] args) {

		//Imprime los primeros 100 numero con el bucle FOR
		
		for(int i = 0 ; i<=100 ; i++) {
			System.out.println(i);
		}
		
		//Función lambda con streams
		List<String> frutas = new ArrayList<String>();
		frutas.add("Manzana");
		frutas.add("Wanabana");
		frutas.add("Cereza");
		frutas.add("Naranja");
		
		frutas.stream().forEach(elemento -> System.out.println(elemento));
		frutas.stream().forEach(System.out::println);
	}

}
