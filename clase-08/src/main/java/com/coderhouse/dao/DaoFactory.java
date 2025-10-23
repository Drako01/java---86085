package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Alumno;
import com.coderhouse.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
public class DaoFactory implements DAOInterface{ // DAO -> Data Access Object

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void persistirAlumno(Alumno alumno) {
		em.persist(alumno);		
	}

	@Override
	@Transactional
	public void persistirCurso(Curso curso) {
		em.persist(curso);		
	} 

}
