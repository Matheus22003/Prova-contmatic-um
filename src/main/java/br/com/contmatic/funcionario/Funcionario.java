package br.com.contmatic.funcionario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.contmatic.validacoes.Validacoes;

public class Funcionario {
	
	private String nome;
	
	private Date dataNascimento;
	
	private String cargo;
	
	private double salario;

	public Funcionario(String eNome,String eDataNascimento, String eCargo, double eSalario) {
			this.setNome(eNome);
			this.setDataNascimento(eDataNascimento);
	}
	
	public Boolean setNome(String eNome) {
		if(Validacoes.isNonNumeric(eNome) || !eNome.equals(null)) {
			this.nome = eNome;
			return true;
		}
		else {
			return false;
		}
	}

	public String getNome() {
		return this.nome;
	}
	
	public Boolean setDataNascimento(String eDataNascimento) {
		if(!Validacoes.isNonNumeric(eDataNascimento)) {
			try {
				dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(eDataNascimento);
				return true;
			} catch (ParseException e) {
				e.getMessage();
				return false;
			}
		}
		else {
			return false;
		}
	}

	public String getDataNascimento() {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
		return dateFormat.format(dataNascimento.toString());
	}
	
	public Boolean setCargo(String eCargo) {
		if(Validacoes.isNonNumeric(eCargo)) {
			this.cargo = eCargo;
		}
		return false;
	}
	
	public String getCargo() {
		return this.cargo;
	}

	public Boolean setSalario(double eSalario) {
		if (eSalario >= 1100.00) {
			this.salario = eSalario;
			return true;
		}
		return false;
	}
	
	public double getSalario() {
		return this.salario;
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

	@Override
	public String toString() {
		return "Nome: " + this.nome + "\n" + "Idade: " + this.idade + "\n" + "Cargo: " + this.cargo + "\n" + "Salario: "
				+ this.salario;
	}
}
