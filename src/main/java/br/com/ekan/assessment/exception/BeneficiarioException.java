package br.com.ekan.assessment.exception;

public class BeneficiarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeneficiarioException(String message) {
		super(message);
	}

	public BeneficiarioException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BeneficiarioException(Throwable cause) {
		super(cause);
	}
	
}
