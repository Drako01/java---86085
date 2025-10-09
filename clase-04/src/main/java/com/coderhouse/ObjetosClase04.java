package com.coderhouse;

import com.coderhouse.objetos.animados.Perro;
import com.coderhouse.objetos.animados.Persona;

//import com.coderhouse.objetos.animados.Perro;

public class ObjetosClase04 {

	public static void main(String[] args) throws Exception {

		// Creamos nuestro primer Perro
		//Perro primerPerro = new Perro();
		/*
		primerPerro.nombre = "Firualay";
		primerPerro.color = "Marron";
		primerPerro.edad = 5;
		primerPerro.peso = 23.5f;
		primerPerro.raza = "Golden";
		primerPerro.tamanio = "Grande";
		*/
		/*
		System.out.println("Nombre: "+primerPerro.nombre);
		System.out.println("color: "+primerPerro.color);
		System.out.println("edad: "+primerPerro.edad);
		System.out.println("peso: "+primerPerro.peso);
		System.out.println("raza: "+primerPerro.raza);
		System.out.println("tamanio: "+primerPerro.tamanio);
		
		primerPerro.comer();
		primerPerro.saltar();
		primerPerro.camianr();
		
		System.out.println("Mi Perro, " + primerPerro);
		
		
		Perro segundoPerro = new Perro();
		
		
		segundoPerro.setNombre("Firualay");
		segundoPerro.setEdad(6);
		segundoPerro.setColor("Marron");
		segundoPerro.setPeso(20.5f);
		segundoPerro.setRaza("Golden");
		segundoPerro.setTamanio("Grande");
		*/
		//System.out.println(segundoPerro);
		/*
		segundoPerro.comer();
		segundoPerro.saltar();
		segundoPerro.caminar();
		*/
		// Invocamos metodos estaticos, no necesitamos instanciar la clase
		/*
		System.out.println(segundoPerro.mostrarAtributos());
		Perro.ladrar();
		Math.random();
		
		Perro tercerPerro = new Perro();
		
		tercerPerro.setNombre("Daisy");
		tercerPerro.setEdad(4);
		tercerPerro.setColor("Beige");
		tercerPerro.setPeso(3.5f);
		tercerPerro.setRaza("Yorky");
		tercerPerro.setTamanio("Chico");
		
		System.out.println(tercerPerro.mostrarAtributos());
		
		*/
		/*
		double radio = 2.5;
		
		System.out.println("El área de un círculo de radio " + radio 
				+ " cm. es de " + calcularElAreaDeUnCirculo(radio) + " cm.2");
		
		*/
		/*
		String[] nombres = new String[] {
				"Marta",
				"Nicolas",
				"Cielo",
				"Jerlib",
				"Alejandro",
				nombreA,
				nombreB
		};
		
		
		imprimirListaDeNombres(nombres);
		*/
		
		Persona marta = new Persona();
		marta.setNombre("Marta");
		marta.setApellido("Olivares");
		marta.setEdad(28);
		marta.setEmail("marta@mail.com");
		
		marta.hablar();
		System.out.println(marta);
	}
	
	public static double calcularElAreaDeUnCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);
	}

	public static void imprimirListaDeNombres(String[] nombres) {
		for(String nombre: nombres) {
			System.out.println("Nombre: " + nombre);
		}
	}
	
	//Declaro primero
	static final double PI;
	static final double DOUBLE_PI;
	
	
	// Asigno despues
	static {
		PI = 3.141526;
		DOUBLE_PI = 6.28;
	}
	
	static String nombreA = "Eloisa";
	static String nombreB = "Alex";
}
