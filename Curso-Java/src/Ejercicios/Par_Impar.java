package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Par_Impar {

	public static void main(String[] args) throws IOException {

		System.out.println("Ingresar un número: ");
		Double numero = cargarNumero();

		Boolean esPar = (numero % 2) == 0;
		
		if (esPar) {
			System.out.println("El valor es par");
		}
		else {
			System.out.println("El valor es impar");
		}
	}
	
	public static double cargarNumero() throws IOException {
		InputStreamReader capturarTeclado = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(capturarTeclado);
		String strNumero1 = buffer.readLine();
		Double numero1 = Double.parseDouble(strNumero1);
		return numero1;
	}

}
