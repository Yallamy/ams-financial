package br.com.mesttra.financial.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionGlobalHandler {

	@ExceptionHandler(value = ValidationException.class)
	public @ResponseBody String handleValidationException(ValidationException ex) {
		return ex.getErro().getCodigoErro();
	}

}
