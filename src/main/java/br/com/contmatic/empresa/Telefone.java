package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import br.com.contmatic.validator.Validacoes;

public class Telefone {

	String digitoPais;

	String ddd;

	String numeroTelefone;

	public Telefone(String ddd, String telefone) {
		this.setDigitoPais("55");
		this.setDDD(ddd);
		this.setTelefone(telefone);
	}

	private void setDigitoPais(String eDigitoPais) {
		Validacoes.isNumeric(eDigitoPais);
		this.digitoPais = eDigitoPais;
	}

	public String getDigitoPais() {
		return this.digitoPais;
	}

	public void setDDD(String eDDD) {
		varifierDDD(eDDD);
		this.ddd = eDDD;
	}

	private void varifierDDD(String eDDD) throws ExceptionInInitializerError {
		Validacoes.isNumeric(eDDD);
		Set<String> listaDDD = listaDDD();
		if (!listaDDD.contains(eDDD)) {
			throw new ExceptionInInitializerError("DDD inexistente");
		}
	}

	private Set<String> listaDDD() {
		Set<String> listaDDD = new HashSet<>();
		listaDDD.add("61");
		listaDDD.add("62");
		listaDDD.add("64");
		listaDDD.add("65");
		listaDDD.add("66");
		listaDDD.add("67");
		listaDDD.add("82");
		listaDDD.add("71");
		listaDDD.add("73");
		listaDDD.add("74");
		listaDDD.add("75");
		listaDDD.add("77");
		listaDDD.add("85");
		listaDDD.add("88");
		listaDDD.add("98");
		listaDDD.add("99");
		listaDDD.add("83");
		listaDDD.add("81");
		listaDDD.add("87");
		listaDDD.add("86");
		listaDDD.add("89");
		listaDDD.add("84");
		listaDDD.add("79");
		listaDDD.add("68");
		listaDDD.add("96");
		listaDDD.add("92");
		listaDDD.add("97");
		listaDDD.add("91");
		listaDDD.add("93");
		listaDDD.add("94");
		listaDDD.add("69");
		listaDDD.add("95");
		listaDDD.add("63");
		listaDDD.add("27");
		listaDDD.add("28");
		listaDDD.add("31");
		listaDDD.add("32");
		listaDDD.add("33");
		listaDDD.add("34");
		listaDDD.add("35");
		listaDDD.add("37");
		listaDDD.add("38");
		listaDDD.add("21");
		listaDDD.add("22");
		listaDDD.add("24");
		listaDDD.add("11");
		listaDDD.add("12");
		listaDDD.add("13");
		listaDDD.add("14");
		listaDDD.add("15");
		listaDDD.add("16");
		listaDDD.add("17");
		listaDDD.add("18");
		listaDDD.add("19");
		listaDDD.add("41");
		listaDDD.add("42");
		listaDDD.add("43");
		listaDDD.add("44");
		listaDDD.add("45");
		listaDDD.add("46");
		listaDDD.add("51");
		listaDDD.add("53");
		listaDDD.add("54");
		listaDDD.add("55");
		listaDDD.add("47");
		listaDDD.add("48");
		listaDDD.add("49");
		return listaDDD;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setTelefone(String eTelefone) {
		validacoesTelefone(eTelefone);
		this.numeroTelefone = eTelefone;
	}

	private void validacoesTelefone(String eTelefone) {
		Validacoes.isNumeric(eTelefone);
		if (eTelefone.length() != 9 && eTelefone.length() != 8) {
			throw new ExceptionInInitializerError("Quatidade de caracteres inseridas de maneira incorreta");
		}
	}

	public String getTelefone() {
		return this.numeroTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((digitoPais == null) ? 0 : digitoPais.hashCode());
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (digitoPais == null) {
			if (other.digitoPais != null)
				return false;
		} else if (!digitoPais.equals(other.digitoPais))
			return false;
		if (numeroTelefone == null) {
			if (other.numeroTelefone != null)
				return false;
		} else if (!numeroTelefone.equals(other.numeroTelefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [digitoPais=" + digitoPais + ", ddd=" + ddd + ", numeroTelefone=" + numeroTelefone + "]";
	}

}
