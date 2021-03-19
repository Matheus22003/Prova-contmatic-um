package br.com.contmatic.exception;

public class CpfInvalidoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1027561118331311749L;

	public CpfInvalidoException(String msg) {
		super(msg);
	}

	public CpfInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
