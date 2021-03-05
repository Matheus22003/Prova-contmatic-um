package br.com.contmatic.endereco;

import br.com.contmatic.validacoes.Validacoes;

public class Endereco {

	private String rua;

	private Integer numero;

	private String complemento;

	private String bairro;

	private String municipio;

	private String cidade;

	private String cep;

	public Endereco(String eRua, int eNumero, String eComplemento, String eBairro, String eMunicipio, String eCidade, String eCep) {
		this.setRua(eRua);
		this.setNumero(eNumero);
		this.setComplemento(eComplemento);
		this.setBairro(eBairro);
		this.setMunicipio(eMunicipio);
		this.setCidade(eCidade);
		this.setCep(eCep);
	}

	public boolean setRua(String eRua) {
		if (eRua == null || eRua.equals("") || eRua.equals(" ") || !Validacoes.isNonNumeric(eRua)) {
			return false;
		} else {
			rua = eRua;
			return true;
		}
	}

	public String getRua() {
		return this.rua;
	}

	public boolean setNumero(int eNumero) {
		this.numero = eNumero;
		return true;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public boolean setComplemento(String eComplemento) {
		this.complemento = eComplemento;
		return true;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public boolean setBairro(String eBairro) {
		if (!Validacoes.isNonNumeric(eBairro)) {
			return false;
		} else {
			this.bairro = eBairro;
			return true;
		}
	}

	public String getBairro() {
		return this.bairro;
	}

	public Boolean setMunicipio(String eMunicipio) {
		if (!Validacoes.isNonNumeric(eMunicipio)) {
			return false;
		} else {
			this.municipio = eMunicipio;
			return true;
		}
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public Boolean setCidade(String eCidade) {
		if (!Validacoes.isNonNumeric(eCidade)) {
			return false;
		} else {
			this.cidade = eCidade;
			return true;
		}
	}

	public String getCidade() {
		return this.cidade;
	}

	public Boolean setCep(String eCep) {
		if(Validacoes.isNonNumeric(eCep)) {
			this.cep = eCep;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getCep() {
		return this.cep;
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
