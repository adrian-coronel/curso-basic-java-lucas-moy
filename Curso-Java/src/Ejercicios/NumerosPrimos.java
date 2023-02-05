package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class NumerosPrimos {

	  public static void main(String[] args) {
	    
		numerosPrimos(100);  
		  
	  }
	   
	   public static void numerosPrimos(int Minumero) {
		   ArrayList<Integer> Divisores = new ArrayList<Integer>();
	       ArrayList<Integer> NumerosP = new ArrayList<Integer>();

	       int n=1;

	       while(n<=1000) {
	           for(int i=1; i<=n ;i++) {
	               if(n%i==0){
	                   Divisores.add(i);
	               }}
	           
	           int longitud = Divisores.size();
	           if(longitud==2){
	               NumerosP.add(n);
	           }
             Divisores.clear();
             n++;
	           if(NumerosP.size()==Minumero) {
	               break;
	           }
	       }
	       System.out.println(NumerosP);

		   
	   }
	   
	   

}
