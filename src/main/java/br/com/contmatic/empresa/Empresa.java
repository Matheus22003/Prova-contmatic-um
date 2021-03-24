package br.com.contmatic.empresa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.contmatic.validator.Validacoes;
import br.com.contmatic.validator.ValidatorEmpresa;

public class Empresa {

	private String cnpj;

	private Endereco endereco;

	private List<Funcionario> funcionarios = new ArrayList<>();

	private String areaDeAtuacao;

	public Empresa(String cCNPJ) {
		this.setCnpj(cCNPJ);
	}

	public Empresa(String cnpj, Endereco endereco, String areaDeAtuacao) {
		this.setCnpj(cnpj);
		this.setEndereco(endereco);
		this.setAreaDeAtuacao(areaDeAtuacao);
	}

	public void setCnpj(String eCnpj) {
		ValidatorEmpresa.validaCnpj(eCnpj);
		cnpj = eCnpj;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public boolean setEndereco(Endereco eEndereco) {
		endereco = eEndereco;
		return true;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setAreaDeAtuacao(String eAreaDeAtuacao) {
		Validacoes.isStringNull(eAreaDeAtuacao);
		this.areaDeAtuacao = eAreaDeAtuacao;
	}

	public String getAreaDeAtuacao() {
		return this.areaDeAtuacao;
	}

	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	public int getQuantidadeDeFuncionarios() {
		return this.funcionarios.size();
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(funcionarios);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	@Override
	public String toString() {

		if (funcionarios.isEmpty()) {

			return "CNPJ: " + this.cnpj + "\n" + "Endere�o: " + this.endereco + "\n" + "Area de Atua��o: "
					+ areaDeAtuacao + "\n" + "Ainda n�o possui nenhum funcionario!";
		} else {
			return "CNPJ: " + this.cnpj + "\n" + "Endere�o: " + this.endereco + "\n" + "Quantidade de Funcionarios: "
					+ funcionarios.size() + "\n" + "Area de Atuação: " + areaDeAtuacao;

		}
	}

}
