package com.store.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ExceptionResponse {
	
	private LocalDateTime fecha;
	private String mensaje;
	private String detalle;

}
