package com.coderhouse;

public class Clase01 {

	public static void main(String[] args) {
		
		//Tipo Nombre
		String frase = "Hola desde Java..!!!";
		String subrayado = "- - - - - - - - - - - - - - - - -";
		//console.log(frase);
		/*System.out.println(frase);
		System.out.println("-----------------");
		System.out.println(frase);
		System.out.println(subrayado);*/
		
		short year = 2025;
		byte day = 30;
		String month = "Septiembre";
		
		//System.out.println("Hoy es " + day + " de " + month + " de " + year);
		
		String indefinida = null;
		
		indefinida = "20";
		indefinida = "Hola desde variable indefinida.!";
		//System.out.println(indefinida);
		
		// Operaciones aritmeticas
		short suma = 123 + 25;
		//System.out.println(suma);
		
		short numeroA = 123;
		short numeroB = 25;
		short resultado = (short) (numeroA + numeroB);
		
		//System.out.println(resultado);
		
		byte numA = 12;
		byte numB = 23;
		byte result = (byte) (numA + numB); // Casteo de datos
		int result2 = numA + numB;  // Sin casteo
		
		int result3 = numA * numB; // Asi con cualquier tipo de operacion aritmetica
		
		//System.out.println(result3);
		
		float division = (float) numA / (float) numB;
		//System.out.println(division);
		
		// Constantes
		final int NUMERO_A = 12; // Me aseguro que esto es una Constante
		
		//NUMERO_A = 23; -> No se puede reasignar
		//System.out.println(NUMERO_A);
		
		// Como funciona un contador
		int contador = 0;
		contador = contador + 1;
		contador = contador + 1;
		contador = contador + 1;
		contador++;
		contador++;
		contador++;
		contador++;
		//System.out.println(contador);
		
		// Todas estas operaciones devuelven Booleans
		
		byte numberA = 12;
		byte numberB = 3;
		byte numberC = 6;
		char numberD = '6';
		
		String numberE = "6";
		
		System.out.println(numberA == numberA); // numberA es igual a numberA ??
		System.out.println(numberA == numberB);
		System.out.println(numberA != numberB);
		System.out.println(numberA < numberB);
		System.out.println(numberA > numberB);
		System.out.println(numberA >= numberB);
		System.out.println(numberA >= numberB);
		
		System.out.println(numberC > numberD);// ?? false
		//System.out.println(numberC > numberE);// ?? false
		
		String nombreEmpleados = "";
		
	}

}
