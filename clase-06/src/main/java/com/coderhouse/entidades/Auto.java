package com.coderhouse.entidades;

import com.coderhouse.abstractas.Vehiculo;

public class Auto extends Vehiculo {

	@Override
	public void encender() {
		System.out.println("Mi Auto " + this.getMarca() + " esta encendiendo");
	}

	@Override
	public void apagar() {
		System.out.println("Mi Auto " + this.getMarca() + " se esta apagando");
	}

	@Override
	public void mover() {
		System.out.println("Mi Auto " + this.getMarca() + " se esta moviendo");
	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", ruedas=" + ruedas + "]";
	}

	
}
