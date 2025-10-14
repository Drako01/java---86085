package com.coderhouse.excepciones;

public class EdadDelPerroException extends Exception {

	public EdadDelPerroException(String message) {
		super("Ups... "+message+", Esto es un Error.!!");
	}

	
}
