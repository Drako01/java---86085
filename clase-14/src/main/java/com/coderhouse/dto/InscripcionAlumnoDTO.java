package com.coderhouse.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de Inscrpciones de Alumnos a uno o varios Cursos")
public class InscripcionAlumnoDTO {
	
	@Schema(description = "ID del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long alumnoId;
	
	@Schema(description = "IDs de Cursos disponibles", requiredMode = Schema.RequiredMode.REQUIRED)
	@ArraySchema(minItems = 1, uniqueItems = true, schema = @Schema(implementation = Long.class, example = "1"))
	private List<Long> cursoIds;
}
