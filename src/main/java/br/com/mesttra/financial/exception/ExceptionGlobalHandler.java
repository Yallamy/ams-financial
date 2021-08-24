package br.com.mesttra.financial.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionGlobalHandler {

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<String> handleValidationException(ValidationException ex) {
		
		log.error(ex.getErro().getCodigoErro());
		return new ResponseEntity<>(ex.getErro().getCodigoErro(), ex.getErro().getHttpStatus()); 
	}
}
