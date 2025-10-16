package com.coderhouse.entidades.caninos;

import com.coderhouse.entidades.Mascota;
import com.coderhouse.interfaces.PerroInterface;

public class Perro extends Mascota implements PerroInterface {

	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perro(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void olfatear() {
		System.out.println("Mi Perro " + super.getNombre() + " esta olfateando");		
	}

	@Override
	public void ladrar() {
		System.out.println("Mi Perro " + super.getNombre() + " esta ladrando");			
	}

	@Override
	public void moverLaCola() {
		System.out.println("Mi Perro " + super.getNombre() + " esta moviendo la cola");			
	}
	
	@Override
	public void comer() {
		System.out.println("Mi Perro " + super.getNombre() + " esta comiendo");			
	}

	@Override
	public void dormir() {
		System.out.println("Mi Perro " + super.getNombre() + " esta durmiendo");	
	}
	
	@Override
	public String toString() {
		return "Mi Perro " + super.getNombre() + " es muy bueno";
	}

	@Override
	public void respirar() {
		if(super.estaVivo()) {
			System.out.println("Mi Perro " + super.getNombre() + " esta Feliz y respirando");
		} else {
			System.err.println("Pobre mi " + super.getNombre() + " Se murio y dejo de respirar.");
		}
		
	}


	@Override
	public void jugar() {
		System.out.println("Mi Perro " + super.getNombre() + " esta jugando");		
	}
	
	@Override
	public String emitirSonido() {
		return "Mi Perro " + super.getNombre() + " esta ladrando";		
	}
	
}
