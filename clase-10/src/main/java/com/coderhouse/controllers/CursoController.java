package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Curso;
import com.coderhouse.repository.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public ResponseEntity<List<Curso>> getAllCursos(){
		try {
			List<Curso> cursos = cursoRepository.findAll();
			return ResponseEntity.ok(cursos); // Code 200
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@GetMapping("/{cursoId}")
	public ResponseEntity<Curso> getCursoById(@PathVariable Long cursoId){
		try {
			if(!cursoRepository.existsById(cursoId)) {
				return ResponseEntity.notFound().build(); // Code 404 -> curso no existe				
			} 
			Curso curso = cursoRepository.findById(cursoId).get();
			return ResponseEntity.ok(curso); // 200
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
		try {
			Curso cursoCreado = cursoRepository.save(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado); // Code 201
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	
}
