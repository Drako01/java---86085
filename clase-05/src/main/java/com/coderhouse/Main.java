package com.coderhouse;

//import com.coderhouse.entities.Animal;
//import com.coderhouse.entities.mascotas.Mascota;
import com.coderhouse.entities.mascotas.canina.Perro;
import com.coderhouse.entities.mascotas.felinos.Gato;
import com.coderhouse.entities.salvajes.aves.Aguila;
import com.coderhouse.excepciones.DivisionPorCeroException;
import com.coderhouse.excepciones.EdadDelPerroException;

public class Main {

	public static void main(String[] args) throws Exception {
		/*try {
		
		Perro perro = new Perro();
		perro.setEspecie("Canina");
		perro.setNombre("Firulay");		
		perro.setComestible(false);
		perro.setEdad(5);
		System.out.println(perro);
		perro.comer();
		
		//Mascota perro2 = new Mascota();
		Perro perro2 = new Perro();
		perro2.setEspecie("Canina");
		perro2.setNombre("Bengi");		
		perro2.setComestible(false);
		perro2.setEdad(16);
		System.out.println(perro2);
		perro2.comer();
		
		} catch (EdadDelPerroException e){
			System.err.println(e.getMessage());
		}
		*/
		// ======================
		/*
		Gato gatito = new Gato();
		gatito.setEspecie("Felina");
		gatito.setNombre("Miyi");		
		gatito.setComestible(false);
		gatito.setEdad(6);
		System.out.println(gatito);
		gatito.comer();
		
		Aguila aguila = new Aguila();
		aguila.setEspecie("Voladora");
		aguila.setComestible(true);
		aguila.setHabitat("Salvaje");
		
		System.out.println(aguila);
		aguila.comer();
		
		Perro perrito = new Perro("Canina");
		System.out.println(perrito);
		*/
		try {
			int numero = 10;
			int divisor = 0;
			
			if(divisor == 0) {
				throw new DivisionPorCeroException("No se puede dividir por cero");
			}
		   int resutado = numero / divisor;
			
			System.out.println("Resultado: "+resutado);
		} catch (DivisionPorCeroException e) {
			System.err.println(e.getMessage());
		}
	}

}
