package br.com.mesttra.financial.exception;

import org.springframework.http.HttpStatus;

public interface GenericValidation {
	
	public String getCodigoErro();
	
	public HttpStatus getHttpStatus();

}
