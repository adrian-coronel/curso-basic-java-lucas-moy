package Ejercicios;

public class NumeroPrimoCurso {

	public static void main(String[] args) {
		
		String resultado = "";
		
		int numero = 1;
		int contador = 0;
		
		while(contador < 100) { //Imprime los 100 numeros PRIMOS
			
			if(esPrimo(numero)) {
				resultado += numero + ", "; //Se van concatenando todos los primos
				contador++;
			}
			numero++;
		}
		System.out.println("Los primeros "+contador+" numeros primos son "+ resultado);
	}

	public static boolean esPrimo(int numero) { //Método que retorna TRUE si es Primo
	
		Boolean esUnNumeroPrimo = true;
		
		for (int i = 2 ; i < numero ; i++) {
			
			boolean esPar = numero % i == 0;
			if(esPar) {
				esUnNumeroPrimo = false;
			}
		}
		return esUnNumeroPrimo;
	}
}
