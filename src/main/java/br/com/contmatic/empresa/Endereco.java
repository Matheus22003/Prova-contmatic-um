package br.com.contmatic.empresa;

import br.com.contmatic.validator.Validacoes;

public class Endereco {

	private String rua;

	private Integer numero;

	private String complemento;

	private String bairro;

	private String municipio;

	private String cidade;

	private String cep;

	public Endereco() {
		
	}
	
	public Endereco(String eRua, int eNumero, String eComplemento, String eBairro, String eMunicipio, String eCidade,
			String eCep) {
		this.setRua(eRua);
		this.setNumero(eNumero);
		this.setComplemento(eComplemento);
		this.setBairro(eBairro);
		this.setMunicipio(eMunicipio);
		this.setCidade(eCidade);
		this.setCep(eCep);
	}

	public void setRua(String eRua) {
		Validacoes.isNonNumeric(eRua);
		rua = eRua;
	}

	public String getRua() {
		return this.rua;
	}

	public void setNumero(int eNumero) {
		this.numero = eNumero;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setComplemento(String eComplemento) {
		this.complemento = eComplemento;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setBairro(String eBairro) {
		Validacoes.isNonNumeric(eBairro);
		this.bairro = eBairro;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setMunicipio(String eMunicipio) {
		Validacoes.isNonNumeric(eMunicipio);
		this.municipio = eMunicipio;

	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setCidade(String eCidade) {
		Validacoes.isNonNumeric(eCidade);
		this.cidade = eCidade;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCep(String eCep) {
		Validacoes.isNumeric(eCep);
		this.cep = eCep;

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
