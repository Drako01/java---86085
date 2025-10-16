package com.coderhouse.operaciones;

public class Suma extends Operaciones {

	public Suma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Suma(double a, double b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double operar(double a, double b) {
		return a + b;
	}
	
	@Override
	public void enviarResultado() {
		System.out.println("El resultado de la Suma es " + this.operar(super.a, super.b));
	}
}
