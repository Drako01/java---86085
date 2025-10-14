package com.coderhouse.entities;

public class Animal {

	private String especie;
	private boolean comestible;
	private String sexo;
	
	// Constructores

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Animal(String especie) {
		super();
		this.especie = especie;
	}




	public void hacerSonido() {
		System.out.println(getEspecie() + " esta haciendo un sonido.!");
	}

	public void comer() {
		System.out.println(getEspecie() + " esta comiendo.");
	}
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	
	public boolean isComestible() {
		return comestible;
	}

	public void setComestible(boolean comestible) {
		this.comestible = comestible;
	}

	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	// Sobreescribiendo el metodo principal -> Polimorfismo
	@Override // Decorador
	public String toString() {
		return "Animal [especie=" + especie + "]";
	}
	
	
}
