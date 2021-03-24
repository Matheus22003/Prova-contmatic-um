package br.com.contmatic.exception;

public class CnpjInvalidoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1895022775081465111L;

	public CnpjInvalidoException(String msg) {
		super(msg);
	}

	public CnpjInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
