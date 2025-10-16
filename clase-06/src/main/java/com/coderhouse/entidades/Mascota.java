package com.coderhouse.entidades;

import com.coderhouse.interfaces.AccionesInterface;
import com.coderhouse.interfaces.AnimalInterface;

public class Mascota extends Animal implements AnimalInterface, AccionesInterface{

	private String nombre;
	private int edad;
	private boolean estaVivo;
	
	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Mascota(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
		
	public boolean isEstaVivo() {
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public void comer() {
		System.out.println("La mascota esta comiendo");
	}
	
	@Override
	public void caminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saltar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nadar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dormir() {}

	@Override
	public boolean estaVivo() {
		return this.isEstaVivo();
	}


	@Override
	public void respirar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
