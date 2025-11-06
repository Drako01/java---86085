package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.AsignacionCategoriaDTO;
import com.coderhouse.models.Curso;
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoService svc;

	@GetMapping
	public ResponseEntity<List<Curso>> getAllCursos() {
		try {
			List<Curso> cursos = svc.findAll();
			return ResponseEntity.ok(cursos); // Code 200
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@GetMapping("/{cursoId}")
	public ResponseEntity<Curso> getCursoById(@PathVariable Long cursoId) {
		try {
			Curso curso = svc.findById(cursoId);
			return ResponseEntity.ok(curso); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // Code 404 -> curso no existe
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> createCurso(@RequestBody Curso curso) {
		try {
			Curso cursoCreado = svc.save(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado); // Code 201
		} catch (IllegalStateException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Detalle");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error); // 409 -> Conflicto
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@PutMapping("/{cursoId}")
	public ResponseEntity<Curso> updateCursoById(@PathVariable Long cursoId, @RequestBody Curso cursoActualizado) {
		try {
			Curso curso = svc.update(cursoId, cursoActualizado);
			return ResponseEntity.ok(curso); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // Code 404 -> Curso no existe
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@DeleteMapping("/{cursoId}")
	public ResponseEntity<Void> deleteById(@PathVariable Long cursoId) {
		try {
			svc.deleteById(cursoId);
			return ResponseEntity.noContent().build(); // 204 -> No Content
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // Code 404 -> Alumno no existe
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}

	@PostMapping("/asignar-categoria")
	public ResponseEntity<?> asignarCategoriaACurso(@RequestBody AsignacionCategoriaDTO dto) {
		if (dto.getCursoId() == null || dto.getCategoriaId() == null) {
			return ResponseEntity.badRequest().body("Ambos parametros son requeridos");
		} // Esta logica la debe implementar el Servicio.
		try {
			Curso cursoActualizado = svc.asignarCategoriaACurso(dto.getCursoId(), dto.getCategoriaId());
			return ResponseEntity.ok(cursoActualizado);
		} catch (IllegalStateException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Detalle");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error); // 409 -> Conflicto
		} catch (IllegalArgumentException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Detalle");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Code 404 -> Curso no existe
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
}
