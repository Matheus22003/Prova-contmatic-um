package br.com.contmatic.telefone;

import br.com.contmatic.validacoes.Validacoes;

public class Telefone {

	String digitoPais;

	String ddd;

	String numeroTelefone;
	
	public Telefone(String digitoPais, String ddd, String telefone) {
		this.setDigitoPais(digitoPais);
		this.setDDD(ddd);
		this.setTelefone(telefone);
	}

	public boolean setDigitoPais(String eDigitoPais) {
		if (Validacoes.isNumeric(eDigitoPais) || !eDigitoPais.isEmpty() || !eDigitoPais.isBlank()) {
			this.digitoPais = eDigitoPais;
			return true;
		}
		return false;
	}

	public boolean setDDD(String eDDD) {
		if (Validacoes.isNumeric(eDDD) || !eDDD.isEmpty() || !eDDD.isBlank() || eDDD.length() == 3) {
			this.ddd = eDDD;
			return true;
		}
		return false;
	}
	
	public boolean setTelefone(String eTelefone) {
		if (Validacoes.isNumeric(eTelefone) || !eTelefone.isEmpty() || !eTelefone.isBlank() || (eTelefone.length() == 9 || eTelefone.length() == 8)) {
			this.numeroTelefone = eTelefone;
			return true;
		}
		return false;
	}

	public String getDigitoPais() {
		return this.digitoPais;
	}
	
	public String getDdd() {
		return this.ddd;
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
