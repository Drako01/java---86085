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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/alumnos")
@Tag(name = "Gestion de Alumnos", description = "Endpoints para gestionar Alumnos")
public class AlumnoController {
	
	@Autowired
	private AlumnoService svc;
	
	@Operation(summary = "Obtener la Lista de todos los Alumnos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Alumnos obtenida Correctamente",
					content = {
							@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Alumno.class)))
					}),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))			
		})
	@GetMapping
	public ResponseEntity<?> getAllAlumnos(){
		try {
			List<Alumno> alumnos = svc.findAll();
			return ResponseEntity.ok(alumnos); // Code 200
		} catch(Exception err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Error Interno del Servidor");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // Error 500
		}
	}
	
	@Operation(summary = "Obtener un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno obtenido Correctamente",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "404", description = "Error, Alumno no encontrado", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))			
		})
	@GetMapping("/{alumnoId}")
	public ResponseEntity<?> getAlumnoById(
			@Parameter(description = "Identificador del Alumno", example = "1", required = true) 
			@PathVariable Long alumnoId){		
		try {			
			Alumno alumno = svc.findById(alumnoId);
			return ResponseEntity.ok(alumno); // 200
		} catch(IllegalArgumentException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Alumno no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Code 404 -> Alumno no existe			
		} catch(Exception err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Error Interno del Servidor");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // Error 500
		}
	}
	
	@Operation(summary = "Crear un Alumno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Alumno creado Correctamente",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "409", description = "Error, Conflicto en los datos enviados. No se pudo crear el Alumno", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))			
		})
	@PostMapping("/create")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Datos del Alumno a crear",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Alumno inicial",
							value = "{\"nombre\":\"Laura\",\"apellido\":\"Gonzalez\",\"dni\":\"22333666\",\"legajo\":\"L22333666\",\"edad\":\"25\"}"
							)
					)
			)
	public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno){
		try {
			Alumno alumnoCreado = svc.save(alumno);
			return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado); // Code 201
		} catch (IllegalStateException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Alguno de los datos genera un Conflicto");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error); // 409 -> Conflicto
		} catch(Exception err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Error Interno del Servidor");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // Error 500
		}
	}
	
	@Operation(summary = "Actualizar a un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno actualizado Correctamente",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "404", description = "Error, Alumno no encontrado", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "409", description = "Error, Conflicto en los datos enviados. No se pudo crear el Alumno", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))			
		})
	@PutMapping("/{alumnoId}")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Datos del alumno a actualizar",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Actualizaci\u00f3n de alumno",
							value = "{\"nombre\":\"Ana\",\"apellido\":\"Perez\",\"dni\":11222333}"
					),
					schema = @Schema(implementation = Alumno.class)
			)
	)
	public ResponseEntity<?> updateAlumnoById(
			@Parameter(description = "Identificador del alumno", example = "5", required = true)
			@PathVariable Long alumnoId, 
			@RequestBody Alumno alumnoActualizado){
		try {
			Alumno alumno = svc.update(alumnoId, alumnoActualizado);
			return ResponseEntity.ok(alumno); // 200
		} catch(IllegalArgumentException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Alumno no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);// Code 404 -> Alumno no existe		
		} catch(Exception err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Error Interno del Servidor");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // Error 500
		}
	}
	
	@Operation(summary = "Eliminar un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Alumno eliminado Correctamente",
					content = {@Content()}),
			@ApiResponse(responseCode = "404", description = "Error, Alumno no encontrado", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))			
		})
	@DeleteMapping("/{alumnoId}")
	public ResponseEntity<?> deleteById(
			@Parameter(description = "Identificador del alumno", example = "5", required = true)
			@PathVariable Long alumnoId){
		try {
			svc.deleteById(alumnoId);
			return ResponseEntity.noContent().build(); // 204 -> No Content
		} catch(IllegalArgumentException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Alumno no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Code 404 -> Alumno no existe		
		} catch(Exception err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Error Interno del Servidor");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // Error 500
		}
	}
	
	@Operation(summary = "Inscribir a un Alumno a uno o varios Cursos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno inscripto Correctamente",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))}),
			@ApiResponse(responseCode = "404", description = "Error, Alumno no encontrado", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "409", description = "Error, Conflicto en los datos enviados. No se pudo crear el Alumno", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content(
					mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))			
		})
	@PostMapping("/inscribir")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Identificador del alumno y cursos a inscribir",
			required = true,
			content = @Content(
					mediaType = "application/json",
					examples = @ExampleObject(
							name = "Inscripci\u00f3n m\u00faltiple",
							value = "{\"alumnoId\":5,\"cursoIds\":[1,2,3]}"
					),
					schema = @Schema(implementation = InscripcionAlumnoDTO.class)
			)
	)
	public ResponseEntity<?> inscribirAlumnoACursos(@RequestBody InscripcionAlumnoDTO dto){
		try {
			Alumno alumno = svc.inscribirAlumnoACursos(dto);
			return ResponseEntity.ok(alumno); // 200
		}catch (IllegalStateException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Alguno de los datos genera un Conflicto");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error);  // 409 -> Conflicto
		} catch (IllegalArgumentException err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Alumno no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);// Code 404 -> Alumno no existe
		} catch(Exception err) {
			ErrorResponse error = new ErrorResponse(err.getMessage(), "Error Interno del Servidor");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); // Error 500
		}
	}
}
