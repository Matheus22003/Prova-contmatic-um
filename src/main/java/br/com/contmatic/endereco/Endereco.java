package br.com.contmatic.endereco;

import br.com.contmatic.validacoes.Validacoes;

public class Endereco {
	String rua;

	int numero;

	String complemento;

	public Endereco(String eRua, int eNumero, String eComplemento) {

	}

	public boolean setRua(String eRua) {
		if(eRua == null || eRua == "" || eRua == " " || !Validacoes.isNumeric(eRua)) {
			
		}
		rua = eRua;
		return true;
	}
}
