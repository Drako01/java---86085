package com.coderhouse;

import com.coderhouse.abstractas.Vehiculo;
import com.coderhouse.entidades.Auto;
import com.coderhouse.entidades.caninos.Perro;
import com.coderhouse.operaciones.Suma;
import com.coderhouse.sobrecarga.Impresora;

public class Main {

	public static void main(String[] args) {
		/*
		Perro perrito = new Perro("Firulay", 6);
		perrito.comer();
		perrito.ladrar();
		perrito.moverLaCola();
		perrito.olfatear();
		perrito.dormir();
		perrito.setEstaVivo(false);
		perrito.respirar();
		System.out.println(perrito.emitirSonido());
		System.out.println(perrito);
		
		
		Suma suma = new Suma(12, 56);
		suma.enviarMensaje();
		suma.enviarResultado();
		
		Suma suma2 = new Suma();
		suma2.setA(20);
		suma2.setB(90);
		suma2.enviarMensaje();
		suma2.enviarResultado();
		
		
		Auto auto = new Auto();
		auto.setMarca("Ford");
		auto.setColor("Azul");
		auto.setModelo("Fiesta");
		auto.setRuedas(4);
		auto.encender();
		auto.apagar();
		auto.mover();
		auto.mostrarCantidadDeRuedas();
		System.out.println(auto);
		*/
		
		// Sobrecarga de Metodos
		Impresora imp = new Impresora();
		
		imp.imprimir();
		imp.imprimir(23);
		imp.imprimir(10, 55);
		imp.imprimir("Hola Mundo");
		imp.imprimir("Hola");
		imp.imprimir("Hola", "Coders");
		imp.imprimir("Valor", 2);
		
		Integer[] numeros = {1,2,3,6,8,66,-8,-454,0};
		
		imp.imprimir(numeros);
		
		String[] palabras = {"Hola", "Mundo"};
		
		imp.imprimir(palabras);
	}

}
