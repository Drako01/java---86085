package com.coderhouse.entities.mascotas.canina;

import com.coderhouse.entities.mascotas.Mascota;
import com.coderhouse.excepciones.EdadDelPerroException;

public class Perro extends Mascota {

	static final int EDAD_MAXIMA = 15;
	String messageError = "El Perro no vive mas de " + EDAD_MAXIMA + " de edad";
	
	private String raza;
	private String color;
	

	public Perro() {
		// TODO Auto-generated constructor stub
	}

	
	public Perro(String especie) {
		// TODO Auto-generated constructor stub
	}
	
	

	public Perro(String raza, String color) {
		super();
		this.raza = raza;
		this.color = color;
	}


	@Override
	public void comer() {
		System.out.println(super.getNombre() + " esta comiendo alimento Balanceado especial para Perros.");
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void setEdad(int edad) throws EdadDelPerroException {
		if(edad < 0 || edad > EDAD_MAXIMA) {
			throw new EdadDelPerroException(super.getNombre() + ", " +  messageError);
		}
		super.edad = edad;
	}
}
