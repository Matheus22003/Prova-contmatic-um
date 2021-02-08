package br.com.contmatic.funcionario;

public class Funcionario {
	private String nome;
	private int idade;
	private String cargo;
	private double salario;

	public Funcionario(String eNome, int eIdade, String eCargo, double eSalario) {
		nome = eNome;
		idade = eIdade;
		cargo = eCargo;
		salario = eSalario;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + "\n" + "Idade: " + this.idade + "\n" + "Cargo: " + this.cargo + "\n" + "Salario: "
				+ this.salario;
	}

	@Override
	public int hashCode() {
		int somaDosValoresChar = 0;
		for (int i = 0; i < this.nome.length(); i++) {
			char nomeChar = this.nome.charAt(i);
			somaDosValoresChar += nomeChar;
		}
		return somaDosValoresChar;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Funcionario)) {
			return false;
		}

		if (this.hashCode() == obj.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

	public String getNome() {
		return this.nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public String getCargo() {
		return this.cargo;
	}

	public double getSalario() {
		return this.salario;
	}

	public void clear() {
		this.nome = null;
		this.cargo = null;
		this.idade = 0;
		this.salario = 0;
	}
}
