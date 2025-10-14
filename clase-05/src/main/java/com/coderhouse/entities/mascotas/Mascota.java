package com.coderhouse.entities.mascotas;

import com.coderhouse.entities.Animal;

public class Mascota extends Animal {

	private String nombre;
	protected int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) throws Exception {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Es Comestible? = " + super.isComestible() + " Es una especie " 
				+ super.getEspecie() + ", Se llama " 
				+ this.getNombre() + ", tiene " + this.getEdad() + " de edad";
	}
	
}
