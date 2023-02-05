package input_consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class input_consola {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Ingrese el primer número: ");
		Double numero1 = cargarNumero();
		
		System.out.println("Ingrese el segundo número: ");
		Double numero2 = cargarNumero();
		
		System.out.println("Ingrese el tercer número: ");
		Double numero3 = cargarNumero();
		
		calcularNumeroMayor(numero1,numero2,numero3);
		calcularNumeroMenor(numero1,numero2,numero3);
	}
	
	public static double cargarNumero() throws IOException {
		InputStreamReader capturarTeclado = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(capturarTeclado);
		String strNumero1 = buffer.readLine();
		Double numero1 = Double.parseDouble(strNumero1);
		return numero1;
	}
	
 	public static void calcularNumeroMayor(double numeroUno,double numeroDos,double numeroTres) {
		
		double numeroMayor = numeroUno;
		
		if (numeroDos > numeroMayor) {
			numeroMayor = numeroDos;
		}
		if (numeroTres > numeroMayor) {
			numeroMayor = numeroTres;
		}
		
		System.out.println("El numero mayor es: "+ numeroMayor);		
	}
	
	public static void calcularNumeroMenor(double numeroUno,double numeroDos,double numeroTres) {
		
		double numeroMenor = numeroUno;
		
		if (numeroDos < numeroMenor) {
			numeroMenor = numeroDos;
		}
		if (numeroTres < numeroMenor) {
			numeroMenor = numeroTres;
		}
		
		System.out.println("El numero menor es: "+ numeroMenor);
			
	}

	
}
