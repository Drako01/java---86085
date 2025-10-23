package com.coderhouse.dao;

import com.coderhouse.models.Alumno;
import com.coderhouse.models.Curso;

public interface DAOInterface {
	void persistirAlumno(Alumno alumno);
	void persistirCurso(Curso curso);
}
