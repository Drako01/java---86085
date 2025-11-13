package com.coderhouse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO para Asignacion de Categoria a un Curso")
public class AsignacionCategoriaDTO {
	
	@Schema(description = "ID del Curso", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long cursoId;
	
	@Schema(description = "ID de la Categoria", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long categoriaId;
}
