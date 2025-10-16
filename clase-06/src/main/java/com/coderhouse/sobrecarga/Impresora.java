package com.coderhouse.sobrecarga;

import com.coderhouse.interfaces.ImpresoraInterface;

public class Impresora implements ImpresoraInterface {

	// Sobreescritura de Metodo
	@Override
	public void imprimir() {
		System.out.println("La impresora esta imprimiendo");
	}

	// Sobrecarga de Metodo
	public void imprimir(int numero) {
		System.out.println("La impresora esta imprimiendo el numero " + numero);
	}

	public void imprimir(int a, int b) {
		System.out.println("La impresora esta imprimiendo el numero " + a 
				+ " y el numero " + b);
	}
	
	public void imprimir(String palabras) {
		System.out.println("La impresora esta imprimiendo el String " + palabras);
	}
	
	public void imprimir(String palabra1, String palabra2) {
		System.out.println("La impresora esta imprimiendo la Frase " 
				+ palabra1 + " " + palabra2);
	}
	
	public void imprimir(String palabra, Integer numero) {
		System.out.println("La impresora esta imprimiendo la palabra " 
				+ palabra + " y el numero " + numero);
	}
	
	public void imprimir(Integer[] numeros) {
		System.out.println("Imprimiendo el Array de numeros: ");
		for(Integer n : numeros) {
			System.out.println("Numero: " + n);
		}
	}
	
	public void imprimir(String[] strings) {
		System.out.println("Imprimiendo el Array de Strings: ");
		for(String s : strings) {
			System.out.println("Strings: " + s);
		}
	}
}
