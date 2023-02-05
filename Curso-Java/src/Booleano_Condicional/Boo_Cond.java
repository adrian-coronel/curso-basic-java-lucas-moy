package Booleano_Condicional;

public class Boo_Cond {

	public static void main(String[] args) {
		
		Integer edad = 20;
		
		System.out.println("---- Ejercicio 1 ----");
		//Forma 1
		if ((edad >= 18) && (edad <70)) {
			System.out.println("Es mayor de edad");
		}else {
			System.out.println("Es menor de edad");
		}
		
		//Forma 2
		if (!((edad < 18) || (edad >= 70))) {  //=> NOT((EDAD < 18) OR (EDAD>=70))
			System.out.println("Es mayor de edad");
		}else {
			System.out.println("Es menor de edad");
		}
		
		
		System.out.println("---- Ejercicio 2 ----");
		
		Integer edad2 = 18;
		Boolean esMayorDeEdad = edad2 >= 18;
		
		if (esMayorDeEdad) {
			System.out.println("Es mayor de edad");
		}else {
			System.out.println("Es menor de edad");
		}
		
		
		
		

	}

}
