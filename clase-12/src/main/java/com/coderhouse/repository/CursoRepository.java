package com.coderhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	boolean existsByNombre(String nombre);
}
