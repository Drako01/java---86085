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

import com.coderhouse.dto.InscripcionAlumnoDTO;
import com.coderhouse.models.Alumno;
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
	
	@Autowired
	private AlumnoService svc;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> getAllAlumnos(){
		try {
			List<Alumno> alumnos = svc.findAll();
			return ResponseEntity.ok(alumnos); // Code 200
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@GetMapping("/{alumnoId}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long alumnoId){
		try {			
			Alumno alumno = svc.findById(alumnoId);
			return ResponseEntity.ok(alumno); // 200
		} catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // Code 404 -> Alumno no existe			
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno){
		try {
			Alumno alumnoCreado = svc.save(alumno);
			return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado); // Code 201
		} catch (IllegalStateException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Detalle");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error); // 409 -> Conflicto
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@PutMapping("/{alumnoId}")
	public ResponseEntity<Alumno> updateAlumnoById(
			@PathVariable Long alumnoId, @RequestBody Alumno alumnoActualizado){
		try {
			Alumno alumno = svc.update(alumnoId, alumnoActualizado);
			return ResponseEntity.ok(alumno); // 200
		} catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // Code 404 -> Alumno no existe		
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	
	@DeleteMapping("/{alumnoId}")
	public ResponseEntity<Void> deleteById(@PathVariable Long alumnoId){
		try {
			svc.deleteById(alumnoId);
			return ResponseEntity.noContent().build(); // 204 -> No Content
		} catch(IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // Code 404 -> Alumno no existe		
		} catch(Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
	

	@PostMapping("/inscribir")
	public ResponseEntity<?> inscribirAlumnoACursos(@RequestBody InscripcionAlumnoDTO dto){
		try {
			Alumno alumno = svc.inscribirAlumnoACursos(dto);
			return ResponseEntity.ok(alumno); // 200
		}catch (IllegalStateException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Detalle");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error); // 409 -> Conflicto
		} catch (IllegalArgumentException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Detalle");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Code 404 -> Alumno no existe
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // Error 500
		}
	}
}
