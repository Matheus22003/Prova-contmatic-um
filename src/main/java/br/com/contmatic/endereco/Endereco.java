package br.com.contmatic.endereco;

import br.com.contmatic.validacoes.Validacoes;

public class Endereco {
	
	private String rua;

	private Integer numero;

	private String complemento;

	public Endereco(String eRua, int eNumero, String eComplemento) {
		setRua(eRua);
		setNumero(eNumero);
		setComplemento(eComplemento);
	}

	public boolean setRua(String eRua) {
		if (eRua == null || eRua.equals("") || eRua.equals(" ") || Validacoes.isNumeric(eRua)) {
			return false;
		} else {
			rua = eRua;
			return true;
		}
	}

	public boolean setNumero(int eNumero) {
		this.numero = eNumero;
		return true;
	}

	public boolean setComplemento(String eComplemento) {
		this.complemento = eComplemento;
		return true;
	}

	public String getRua() {
		return this.rua;
	}

	public Integer getNumero() {
		return this.numero;
	}
	
	public String getComplemento() {
		return this.complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + numero;
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Endereco other = (Endereco) obj;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (numero != other.numero)
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + "]";
	}

}
