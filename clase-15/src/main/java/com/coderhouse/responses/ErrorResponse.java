package com.coderhouse.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Response personalizado para errores en general")
public class ErrorResponse {
	
	@Schema(description = "Mensaje de Error", example = "Error", requiredMode = Schema.RequiredMode.REQUIRED)
	private String message;
	
	@Schema(description = "Detalle de Error", example = "Descripcion del Error")
	private String detail;
}
