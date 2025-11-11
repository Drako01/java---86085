package com.coderhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.TimeResponseDTO;
import com.coderhouse.services.FechaService;

@RestController
@RequestMapping("/api/fecha")
public class FechaControllerAPI {

	@Autowired
	private FechaService svc;
	
	private int contador = 0;
	
	private String ultimaFechaMostrada = "N/A";
	
	@GetMapping
	public ResponseEntity<String> obtenerFechaYHoraActuales(){
		contador++;
		
		TimeResponseDTO fechaActual = svc.obtenerFechaYHoraActual();
		
		String message = String.format(
				"Fecha Actual: %s %d %d %d\nHora: %s\nNumero de Invocaciones: %d\nÚltima fecha mostrada: %s",
					fechaActual.getDayOfWeek(),
					fechaActual.getMonth(),
					fechaActual.getDay(),
					fechaActual.getYear(),
					fechaActual.getTime(),
					contador,
					ultimaFechaMostrada
				);
		
		ultimaFechaMostrada = String.format(
					"%s %d %d, %d %s",
					fechaActual.getDayOfWeek(),
					fechaActual.getMonth(),
					fechaActual.getDay(),
					fechaActual.getYear(),
					fechaActual.getTime()
				);
		
		return ResponseEntity.ok(message);
				
	}
}
