package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Alumno;
import com.coderhouse.models.Curso;

@SpringBootApplication
public class Clase08Application implements CommandLineRunner{

	@Autowired // -> Inyecta todas las dependencias
	private DaoFactory dao;
	
	public static void main(String[] args) {
		SpringApplication.run(Clase08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			Curso curso1 = new Curso("Java");
			Curso curso2 = new Curso("JavaScript");
			Curso curso3 = new Curso("React");
			Curso curso4 = new Curso("Angular");
			Curso curso5 = new Curso("SQL");
			
			Alumno alumno1 = new Alumno("Alejandro", "Di Stefano", 22333444, "L22333444", 49);
			Alumno alumno2 = new Alumno("Marta", "Olivares de la Fuente", 33555666, "L33555666", 28);
			Alumno alumno3 = new Alumno("Nicolas", "Riveira", 44333555, "L44333555", 30);
			Alumno alumno4 = new Alumno("Jerlib", "Gonzalez", 66555666, "L66555666", 45);
			Alumno alumno5 = new Alumno("Bianca", "Valbuena", 55222444, "L55222444", 40);
			
			dao.persistirCurso(curso1);
			dao.persistirCurso(curso2);
			dao.persistirCurso(curso3);
			dao.persistirCurso(curso4);
			dao.persistirCurso(curso5);
			
			dao.persistirAlumno(alumno1);
			dao.persistirAlumno(alumno2);
			dao.persistirAlumno(alumno3);
			dao.persistirAlumno(alumno4);
			dao.persistirAlumno(alumno5);
			
		} catch (Exception err) {
			err.getMessage();
		}
		
	}

}
