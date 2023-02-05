package Ejercicios;

public class SerieFibonacci {

	public static void main(String[] args) {
		
		int cantidadDeNumeros = 30;
		int j = 1;
		int e = 0;
		for(int i = 0 ; i<=cantidadDeNumeros ; i++) {
			int resultado = e + j;
			System.out.println(resultado);
			e = j;
			j = resultado;
		}
	}
}
