package br.com.ekan.assessment.infra.exception;

public class DocumentoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DocumentoException(String message) {
		super(message);
	}

	public DocumentoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DocumentoException(Throwable cause) {
		super(cause);
	}

}
