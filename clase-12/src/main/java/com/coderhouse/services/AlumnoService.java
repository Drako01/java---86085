package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dto.InscripcionAlumnoDTO;
import com.coderhouse.interfaces.CRUDInterface;
import com.coderhouse.models.Alumno;
import com.coderhouse.models.Curso;
import com.coderhouse.repository.AlumnoRepository;
import com.coderhouse.repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlumnoService implements CRUDInterface<Alumno, Long> {
	
	private final String message = "Alumno no encontrado";

	@Autowired
	private AlumnoRepository repo;
	
	@Autowired
	private CursoRepository cursoRepo;
	
	@Override
	public List<Alumno> findAll() {
		return repo.findAll();
	}

	@Override
	public Alumno findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(message));
	}

	@Override
	public Alumno save(Alumno nuevoAlumno) {
		if(nuevoAlumno.getDni() != 0 && repo.existsByDni(nuevoAlumno.getDni())) {
			throw new IllegalStateException("Ya existe un alumno con el DNI "+ nuevoAlumno.getDni());
		}
		if(nuevoAlumno.getLegajo() != null && repo.existsByLegajo(nuevoAlumno.getLegajo())) {
			throw new IllegalStateException("Ya existe un alumno con el Legajo "+ nuevoAlumno.getLegajo());
		}
		return repo.save(nuevoAlumno);
	}

	@Override
	@Transactional
	public Alumno update(Long id, Alumno alumnoActualizado) { // alumnoActualizado -> Informacion nueva
		Alumno alumno = findById(id); // Alumno existente
		
		if(alumnoActualizado.getNombre() != null && !alumnoActualizado.getNombre().isEmpty()) {
			alumno.setNombre(alumnoActualizado.getNombre());
		}
		
		if(alumnoActualizado.getApellido() != null && !alumnoActualizado.getApellido().isEmpty()) {
			alumno.setApellido(alumnoActualizado.getApellido());
		}
		
		if(alumnoActualizado.getDni() != 0) {
			alumno.setDni(alumnoActualizado.getDni());
		}
		
		if(alumnoActualizado.getEdad() != 0) {
			alumno.setEdad(alumnoActualizado.getEdad());
		}
		
		if(alumnoActualizado.getLegajo() != null && !alumnoActualizado.getLegajo().isEmpty()) {
			alumno.setLegajo(alumnoActualizado.getLegajo());
		}
		
		return repo.save(alumno); // Se guarda actualizado
	}

	@Override
	public void deleteById(Long id) {
		if(!repo.existsById(id)) {
			throw new IllegalArgumentException(message);
		}
		repo.deleteById(id);
	}

	@Transactional
	public Alumno inscribirAlumnoACursos(InscripcionAlumnoDTO dto) {
		Alumno alumno = repo.findById(dto.getAlumnoId())
				.orElseThrow(() -> new IllegalArgumentException(message));
		
		for (Long cursoId : dto.getCursoIds()) {
			
			Curso curso = cursoRepo.findById(cursoId)
					.orElseThrow(() -> new IllegalArgumentException("El curso con ID: " + cursoId + " no existe.!"));
			
			// Verificar si el Alumno esta inscripto en ese Curso
			if(alumno.getCursos().contains(curso)) {
				throw new IllegalStateException("El Alumno ya esta inscripto en el curso con ID: " + cursoId);
			}
			
			alumno.getCursos().add(curso);
			curso.getAlumnos().add(alumno);
			
			cursoRepo.save(curso);
		}
		
		return repo.save(alumno);
	}
	
}
