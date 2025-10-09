package com.coderhouse.objetos.animados;

public class Perro {

	// Constante o Variables de Clase
	private static final int EDAD_MAXIMA = 15;
	
	String messageError = "El Perro no vive mas de " + EDAD_MAXIMA + " años de edad.";
	
	// Atribuos del Objeto o Variables de Instancia
	private String nombre;
	private String raza;
	private String color;
	private String tamanio;
	private int edad;
	private float peso;
	
	// Metodo 
	public void comer() {
		System.out.println(this.getNombre()+ " esta comiendo");
	}
	
	public void saltar() {
		System.out.println(this.getNombre()+ " esta saltando");
	}
	
	public void caminar() {
		System.out.println(this.getNombre()+ " esta caminando");
	}
	
	// Encapsulamiento
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws Exception {
		if(edad <= 0 || edad > EDAD_MAXIMA) {
			throw new Exception(messageError);
		} else {			
			this.edad = edad;
		}
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}		
	
	public static void ladrar() {
		System.out.println("Guau Guau");
	}
	
	public String mostrarAtributos() {
		return "Mi Perro " + this.getNombre() + " es un " + this.getRaza() 
				+ " de color " + this.getColor() + ", es de Tamaño " + this.getTamanio()
				+ ", tiene " + this.getEdad() + " años de edad, y pesa " + this.getPeso() 
				+ " Kg";
	}
	
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Raza: " + raza + ", Color: " + color + ", Tamaño: " + tamanio + ", Edad: "
				+ edad + " años, Peso: " + peso + " Kg";
	}
}
