package br.com.contmatic.empresa;

public class Empresa {

import java.util.ArrayList;

import br.com.contmatic.funcionario.*;

public class Empresa {

	private String cnpj;

	private String endereco;

	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

	private String areaDeAtuacao;

	public Empresa(String cCNPJ, String cEndereco, String tAreaDeAtuacao) {
		this.setCnpj(cCNPJ);
		endereco = cEndereco;
		this.setAreaDeAtuacao(tAreaDeAtuacao);
	}

	public boolean setCnpj(String eCnpj) {
		ValidacoesEmpresa validacoes = new ValidacoesEmpresa();
		if (validacoes.valdiaCnpj(eCnpj)) {
			cnpj = eCnpj;
			return true;
		} else {
			return false;
		}
	}

	public boolean setEndereco(String eEndereco) {
		endereco = eEndereco;
		return true;
	}

	public boolean setAreaDeAtuacao(String eAreaDeAtuacao) {
		if (eAreaDeAtuacao == null || eAreaDeAtuacao == "" || eAreaDeAtuacao == " ") {
			areaDeAtuacao = eAreaDeAtuacao;
			return true;
		}
		else {
			return false;
		}

	}

	public boolean addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
		return true;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public int getQuantidadeDeFuncionarios() {
		return this.funcionarios.size();
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public String getAreaDeAtuacao() {
		return this.areaDeAtuacao;
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
					+ areaDeAtuacao + "\n" + "Ainda n�o possui nenhum funcion�rio!";
		} else {
			return "CNPJ: " + this.cnpj + "\n" + "Endere�o: " + this.endereco + "\n" + "Quantidade de Funcionarios: "
					+ funcionarios.size() + "\n" + "Area de Atua��o: " + areaDeAtuacao;

		}
	}

}

}
