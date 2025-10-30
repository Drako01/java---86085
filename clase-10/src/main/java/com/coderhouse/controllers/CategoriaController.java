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

import com.coderhouse.models.Categoria;
import com.coderhouse.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategorias(){
		try {
			List<Categoria> categorias = categoriaRepository.findAll();
			return ResponseEntity.ok(categorias); // Code 200
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@GetMapping("/{categoriaId}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long categoriaId){
		try {
			if(!categoriaRepository.existsById(categoriaId)) {
				return ResponseEntity.notFound().build(); // Code 404 -> curso no existe				
			} 
			Categoria categoria = categoriaRepository.findById(categoriaId).get();
			return ResponseEntity.ok(categoria); // 200
			
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria){
		try {
			Categoria categoriaCreada = categoriaRepository.save(categoria);
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreada); // Code 201
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
}
