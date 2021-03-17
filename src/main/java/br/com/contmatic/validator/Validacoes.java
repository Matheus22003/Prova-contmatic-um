package br.com.contmatic.validator;

public class Validacoes {
	public static void isNonNumeric(String str) {
		Validacoes.isStringNull(str);
		if (str.matches(".*\\d.*")) {
			throw new NullPointerException("Valor fornecido contem numeros");
		}
	}
	
	public static void isNumeric(String str) {
		Validacoes.isStringNull(str);
		if (!str.matches("^[0-9]*$")) {
			throw new NullPointerException("Valor fornecido contem letras");
		}
	}

	public static void isStringNull(String valor) {
		if (valor == null || valor.isEmpty() || valor.isBlank())
			throw new NullPointerException("Valor fornecido nulo");
	}
	public static void main(String[] args) {
		Validacoes.isNumeric("d");
	}
}
