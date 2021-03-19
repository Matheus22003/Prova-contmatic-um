package br.com.contmatic.empresa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.contmatic.exception.CpfInvalidoException;
import br.com.contmatic.validator.Validacoes;
import br.com.contmatic.validator.ValidacoesFuncionario;

public class Funcionario {

	private String nome;

	private Date dataNascimento;

	private String cpf;

	private String cargo;

	private double salario;

	public Funcionario(String eCpf) {
		this.setCpf(eCpf);
	}
	
	public Funcionario(String eNome, String eDataNascimento, String ecpf, String eCargo, double eSalario) {
		this.setNome(eNome);
		this.setDataNascimento(eDataNascimento);
		this.setCpf(ecpf);
		this.setCargo(eCargo);
		this.setSalario(eSalario);
	}

	public void setNome(String eNome) {
		Validacoes.isNonNumeric(eNome);
		this.nome = eNome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setDataNascimento(String eDataNascimento) {
		Validacoes.isNumeric(eDataNascimento);
		try {
			dataNascimento = new SimpleDateFormat("dd/mm/yyyy").parse(eDataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public String getDataNascimento() {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		return dateFormat.format(this.dataNascimento);
	}

	public void setCpf(String eCpf) {
		try {
			ValidacoesFuncionario.validaCpf(eCpf);
		} catch (CpfInvalidoException e) {
			e.printStackTrace();
		}
		this.cpf = eCpf;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCargo(String eCargo) {
		Validacoes.isNonNumeric(eCargo);
		this.cargo = eCargo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setSalario(double eSalario) {
		validaSalario(eSalario);
	}

	private void validaSalario(double eSalario) {
		if (eSalario >= 1100.00) {
			this.salario = eSalario;
		}
		else 
			throw new ExceptionInInitializerError("Salário abaixo do mínimo");
	}

	public double getSalario() {
		return this.salario;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", cargo=" + cargo
				+ ", salario=" + salario + "]";
	}

}
