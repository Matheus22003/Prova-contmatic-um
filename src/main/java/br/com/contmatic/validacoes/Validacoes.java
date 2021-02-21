package br.com.contmatic.validacoes;

public class Validacoes {
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
