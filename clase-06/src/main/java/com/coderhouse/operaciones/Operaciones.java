package com.coderhouse.operaciones;

import com.coderhouse.interfaces.OperableInterface;

public class Operaciones implements OperableInterface {

	protected double a;
	protected double b;
	
	
	
	public Operaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Operaciones(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	

	public double getA() {
		return a;
	}


	public void setA(double a) {
		this.a = a;
	}


	public double getB() {
		return b;
	}


	public void setB(double b) {
		this.b = b;
	}


	@Override
	public void enviarMensaje() {
		System.out.println("Ingrese dos Numeros para Operar");
	}

	@Override
	public double operar(double a, double b) {
		return 0;
	}

	@Override
	public void enviarResultado() {
		System.out.println("El resultado de la operacion es " + this.operar(this.a, this.b));
	}

}
