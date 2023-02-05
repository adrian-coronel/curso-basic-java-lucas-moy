package input_consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio_1 {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader capturarTeclado = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(capturarTeclado);
		
		System.out.print("Ingresar el primer valor: ");
		Integer edad1 = Integer.parseInt(buffer.readLine());
		System.out.print("Ingresar el segundo valor: ");
		Integer edad2 = Integer.parseInt(buffer.readLine());
		System.out.print("Ingresar el tercer valor: ");
		Integer edad3 = Integer.parseInt(buffer.readLine());
		
		if(edad1 > edad2) {
			if(edad1 > edad3) {
				System.out.println("El mayor valor es: "+edad1);
			}else {
				System.out.println("El mayor valor es: "+edad3);
			}
		}else if(edad2 > edad1 && edad2 > edad3){
				System.out.println("El mayor valor es: "+edad2);
		}
		

	}

}
