package br.com.mesttra.financial.exception;

import org.springframework.http.HttpStatus;

public enum ValidationEnumMessage implements GenericValidation {

	ERRO_CONSISTENCIA("Objeto requerido null ou vazio", HttpStatus.BAD_REQUEST);
	
	private String codigoErro;

	private HttpStatus httpStatus;
	
	private ValidationEnumMessage(String codigoErro, HttpStatus httpStatus) {
		this.codigoErro = codigoErro;
		this.httpStatus = httpStatus;
	}
	
	@Override
	public String getCodigoErro() {
		return codigoErro;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
}
