package com.coderhouse;

//import java.util.Scanner;

public class Clase02 {

	public static void main(String[] args) {
		/*
		int numeroA = -3; int numeroB = 3;
		//if(esto es verdadero) { ejecuta esto otro }
		/// Vamos a agregar un Chivato
		System.out.println("Empezando ejecucion del Programa...");
		if( numeroA > numeroB ) {
			System.out.println("El numero A es Mayor al numero B");
		} else if (numeroA < numeroB){
			System.out.println("El numero A es Menor al numero B");
		} else {
			System.out.println("Los numeros son Iguales");
		}
		
		System.out.println("Finalizando ejecucion del Programa...");
		*/
		
		// Calculadora
		/*
		int numeroA = 10; int numeroB = 0;		
		
		if(numeroB != 0) {	
			int resultado = numeroA / numeroB;
			System.out.println("El resultado es: "+resultado);
		} else {
			System.err.println("Error, No se puede dividir por Cero");
		}
		*/
		/*
		double numeroA = 10; double numeroB = 30;		
		double resultado = numeroA / numeroB;
		
		if(numeroB != 0) {				
			System.out.println("El resultado es: "+resultado);
		} else {
			System.err.println("Error, No se puede dividir por Cero");
		}
		*/
		
		//Scanner scanner = new Scanner(System.in);
		/*
		System.out.println("Ingrese un numero Entero en formato numerico");
		int numeroIngresado = scanner.nextInt();
		if(numeroIngresado > 0) {
			System.out.println("El numero Ingresado es Positivo");
		} else if(numeroIngresado < 0){
			System.out.println("El numero Ingresado es Negativo");
		} else {
			System.out.println("El numero Ingresado es Cero");
		}
		*/
		/*
		System.out.println("Ingrese un numero para saber que dia de la semana le corresponde");
		int numeroIngresado = scanner.nextInt();
		
		if(numeroIngresado == 1) {
			System.out.println("Hoy es Lunes");
		} else if(numeroIngresado == 2) {
			System.out.println("Hoy es Martes");
		} else if(numeroIngresado == 3) {
			System.out.println("Hoy es Miercoles");
		} else if(numeroIngresado == 4) {
			System.out.println("Hoy es Jueves");
		} else if(numeroIngresado == 5) {
			System.out.println("Hoy es Viernes");
		} else if(numeroIngresado == 6) {
			System.out.println("Hoy es Sabado");
		} else if(numeroIngresado == 7) {
			System.out.println("Hoy es Domingo");
		} else {
			System.err.println("Error, El numero no corresponde a ningun dia de la semana");
		}
		*/
		/*
		System.out.println("Ingrese un numero para saber que dia de la semana le corresponde");
		int numeroIngresado = scanner.nextInt();
		
		switch(numeroIngresado) {
			case 1:
				System.out.println("Hoy es Lunes");
				break;
			case 2:
				System.out.println("Hoy es Martes");
				break;
			case 3:
				System.out.println("Hoy es Miercoles");
				break;
			case 4:
				System.out.println("Hoy es Jueves");
				break;
			case 5:
				System.out.println("Hoy es Viernes");
				break;
			case 6:
				System.out.println("Hoy es Sabado");
				break;
			case 7:
				System.out.println("Hoy es Domingo");
				break;
			default:
				System.err.println("Error, El numero no corresponde a ningun dia de la semana");
		}
		*/
		/*
		System.out.println("Ingrese un numero para saber que dia de la semana le corresponde");
		int numeroIngresado = scanner.nextInt();
		String nombreDeLaSemana = null;
		
		switch(numeroIngresado) {
			case 1:
				nombreDeLaSemana = "Lunes";
				break;
			case 2:
				nombreDeLaSemana = "Martes";
				break;
			case 3:
				nombreDeLaSemana = "Miercoles";
				break;
			case 4:
				nombreDeLaSemana = "Jueves";
				break;
			case 5:
				nombreDeLaSemana = "Viernes";
				break;
			case 6:
				nombreDeLaSemana = "Sabado";
				break;
			case 7:
				nombreDeLaSemana = "Domingo";
				break;
			default:
				System.err.println("Error, El numero no corresponde a ningun dia de la semana");
		}
		
		if(numeroIngresado > 0 && numeroIngresado < 8) {			
			System.out.println("Hoy es " + nombreDeLaSemana);
		}
		*/
		/*
		System.out.println("Ingrese un dia de la semana (con Palabras)");
		
		String diaIngresado = scanner.nextLine().trim().toLowerCase();
		
		switch(diaIngresado) {
			case "lunes", "martes", "miercoles", "miércoles", "jueves", "viernes":
				System.out.println("Hoy es dia Laborable");
				break;
			case "sabado", "sábado", "domingo":
				System.out.println("Hoy es dia de descanso");
				break;
			default:
				System.err.println("Error, El dato ingresado es Incorrecto");			
		}
		
		System.out.println("La ejecucion del programa finalizo...");
		scanner.close();
		*/
		
		// Operadores ternarios
		/*
		int numA = 12;
		int numB = 12;
		
		boolean condicion = numA > numB;
		
		String mensaje = condicion
				? "El numero " + numA + " es Mayor al numero " + numB
				: "El numero " + numA + " es Menor o Igual al numero " + numB;
		
		System.out.println(mensaje);
		*/
		
		// Datos Random
		/*
		float randomNumber = 0;
		
		
		randomNumber =  (float) Math.random(); // Uso de memoria reducido
		
		System.out.println("El numero Random es: " + randomNumber);
		*/
		// Supngamos que solo quiero obtener numeros Random entre 1 y 100
		/*
		int min = 50;
		int max = 100;
		
		int random = (int) (Math.random() * (max - min + 1)) + min;
		
		System.out.println("El numero Random es: " + random);
		*/
		/*
		final double PI = Math.PI;
		
		System.out.println(PI);
		*/
	}
}
