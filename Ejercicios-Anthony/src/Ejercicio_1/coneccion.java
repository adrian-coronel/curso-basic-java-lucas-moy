package Ejercicio_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class coneccion {

	public static void main(String[] args) throws IOException {
		
		 String link = "https://www.bbc.com/";
	        URL url = new URL(link); //Creo un objeto

	                                // (Aqui lo parseo xq no devuelve el mismo tipo)
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();// Me conecto a la URL
	        String encoding = conn.getContentEncoding(); //Obtiene valores que especifican las codificaciones de contenido que se van a usar(Saber en que formato esta encodeado)

	        /*---- Descarga del contenido ----*/
	        InputStream input = conn.getInputStream();

	        String resultado = new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining()); //new InputStreamReader() es un lector de InputStream.lines().collect(Collectors.joining());//Se descarga en la variable String "resultado"
	        System.out.println(resultado);
	}

}
