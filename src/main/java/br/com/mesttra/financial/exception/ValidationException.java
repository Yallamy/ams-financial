package br.com.mesttra.financial.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

@Getter
public class ValidationException extends ResponseStatusException {

	private static final long serialVersionUID = 2989998297275754226L;

	private GenericValidation erro;
	private List<String> parametros = new ArrayList<String>();

	public ValidationException(HttpStatus status) {
		super(status);
	}

	public ValidationException(GenericValidation erro) {

		super(erro.getHttpStatus(), erro.getCodigoErro());

		this.erro = erro;
		this.parametros = new ArrayList<String>();
	}

	public ValidationException(GenericValidation erro, Exception ex) {

		super(erro.getHttpStatus(), erro.getCodigoErro(), ex);
		this.erro = erro;
		this.parametros = new ArrayList<String>();
	}

	public ValidationException(GenericValidation erro, String... params) {

		super(erro.getHttpStatus(), erro.getCodigoErro());
		this.erro = erro;
		this.parametros = Arrays.asList(params);
	}

	public ValidationException(GenericValidation erro, Exception ex, String... params) {

		super(erro.getHttpStatus(), erro.getCodigoErro(), ex);
		this.erro = erro;
		this.parametros = Arrays.asList(params);
	}

	public static final String getPilhaErro(Throwable t) {

		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		t.printStackTrace(printWriter);

		return writer.toString();
	}

}
