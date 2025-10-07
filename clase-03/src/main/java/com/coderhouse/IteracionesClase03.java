package com.coderhouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteracionesClase03 {

	public static void main(String[] args) {
		/*
		// Definimos nuestro primer Array
		int[] numerosEnteros = new int[5];
		
		// Agregamos valores al Array
		numerosEnteros[0] = 2;
		numerosEnteros[1] = 6;
		numerosEnteros[2] = -2;
		numerosEnteros[3] = 23;
		numerosEnteros[4] = -22;
		//numerosEnteros[5] = 202;
		// Imprimimos solo la posicion en la memoria de esta forma
		System.out.println("Posicion en Memoria del Array: " + numerosEnteros);
		// Imprimir los valores
		System.out.println("El valor con indice 0 es: "+numerosEnteros[0]);
		System.out.println("El valor con indice 1 es: "+numerosEnteros[1]);
		System.out.println("El valor con indice 2 es: "+numerosEnteros[2]);
		System.out.println("El valor con indice 3 es: "+numerosEnteros[3]);
		System.out.println("El valor con indice 4 es: "+numerosEnteros[4]);
		numerosEnteros[4] = 522;
		System.out.println("El valor con indice 4 (Reasignado) es: "+numerosEnteros[4]);
		*/
		/*
		String[] palabras = new String[5];
		
		System.out.println("El elemento en la posicion 3 es: " + palabras[3]);
		System.out.println("El elemento en la posicion 4 es: " + palabras[4]);
		*/
		/*
		String[] palabras = {
				"Hola",
				"Mundo",
				"CoderHouse",
				"Argentina",
				"Alejandro"
		};
		System.out.println("El elemento en la posicion 3 es: " + palabras[3]);
		
		int[] numeros = {1,2,3};
		
		System.out.println("El Array palabras tiene " + palabras.length + " elementos");
		// Convertimos el Array en un String para poder imprimir sus valores
		System.out.println("Los elementos del Array palabras son: " + Arrays.toString(palabras));
		System.out.println("Los elementos del Array numeros son: " + Arrays.toString(numeros));
		*/
		
		
		//Listas
		
		List<String> palabras = new ArrayList<>();
		
		List<String> palabras2 = new ArrayList<>();
		
		palabras.add("Hola"); // 0
		palabras.add("Mundo"); // 1
		palabras.add("Coder"); // 2
		palabras.add("Java"); // 3
		//palabras.add("Palabra");
		//palabras.add("Palabra2");
		
		palabras2.add("Palabra"); // 0
		palabras2.addAll(palabras);
		palabras2.add("Palabra2"); // 5
		
		//System.out.println("Los elementos de la Lista palabras son: "+palabras);
		//System.out.println("Los elementos de la Lista palabras2 son: "+palabras2);
		
		//palabras.removeAll(palabras2); // Intento eliminar todos los elementos de palabras2 de palabras
		//palabras.clear(); // Borra todo el contenido de la Lista
		//System.out.println("Los elementos de la Lista palabras son: "+palabras);
		
		// Hacer consultas sobre el contenido de la Lista
		/*
		System.out.println(palabras2.containsAll(palabras)); // palabras2 contiene todo el contenido de palabras ???
		System.out.println(palabras.containsAll(palabras2));// palabras contiene todo el contenido de palabras2 ???
		 */
		// Cantidad de elemetos de la Lista?
		//System.out.println("La cantidad de elementos de la Lista palabras es: " + palabras.size() + " elementos");
		//palabras.clear();
		/*
		if(palabras.isEmpty()) {
			System.out.println("La Lista palabras esta vacia");
		} else {
			System.out.println("La Lista palabras: " + palabras);
			System.out.println("La cantidad de elementos de la Lista palabras es: " + palabras.size() + " elementos");
			// Imprimir 1 solo elemento de la Lista (Indice 2)
			//System.out.println(palabras.get(2));
			
			
			// Metodos para recorrer Listas
			for(String palabra: palabras) {
				int index = palabras.indexOf(palabra); // Extraer el indice de cada elemento
				System.out.println("El indice de la palabra "+palabra+ " es: "+index);
			}
			
			for(int i = 0; i < palabras.size(); i++) {
				System.out.println("(Ciclo for) El indice de la palabra "+ palabras.get(i) + " es: "+ i);
			}
			
			
			Iterator<String> iterator = palabras.iterator();
			
			while(iterator.hasNext()) {
				String palabra = iterator.next(); // Arranca desde 0
				System.out.println("(Usamos Iterator) Palabra "+ palabra);
				iterator.remove(); // Desasigna el valor a iterator y usa el siguiente
			}
		}
		*/
		
		// while y do while
		/*
		int index = 0;
		
		while(!palabras.isEmpty() && index < palabras.size()) {
			System.out.println("Palabra (usando while) " + palabras.get(index));
			index++;
		}		
		System.out.println("===============================");
		
		index = 0; // Reinicializamos el valor de index a 0
		if(!palabras.isEmpty()) {
			do {
				System.out.println("Palabra (usando do while) " + palabras.get(index));
				index++;
			} while(index < palabras.size());
		} else {
			System.err.println("La Lista esta vacia");
		}
		System.out.println("===============================");
		*/
		
		// Metodos de manipulacion de Listas
		palabras.add("Nueva");
		palabras.add("Otra Nueva"); // Agrega
		palabras.remove(0); // Elimina por Indice
		palabras.remove("Coder"); // Elimina por valor
		palabras.set(3, "Otra"); // Para reemplazar
		System.out.println("La Lista palabras: "+palabras);
		
		// Usando foreach
		palabras.forEach( palabra -> {
			System.out.println("(Usando foreach) Palabra: "+palabra);
		});
	}

}
