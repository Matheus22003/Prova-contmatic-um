package br.com.contmatic.funcionario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.contmatic.validacoes.Validacoes;

public class Funcionario {
	
	private String nome;
	
	private Date dataNascimento;
	
	private String cpf;
	
	private String cargo;
	
	private double salario;

	public Funcionario(String eNome,String eDataNascimento,String ecpf, String eCargo, double eSalario) {
			this.setNome(eNome);
			this.setDataNascimento(eDataNascimento);
			this.setCpf(ecpf);
			this.setCargo(eCargo);
			this.setSalario(eSalario);
	}
	
	public Boolean setNome(String eNome) {
		if(Validacoes.isNonNumeric(eNome)) {
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
		if(Validacoes.isNonNumeric(eDataNascimento)) {
			try {
				dataNascimento = new SimpleDateFormat("dd/mm/yyyy").parse(eDataNascimento);
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
		return dateFormat.format(this.dataNascimento);
	}
	
	public Boolean setCpf(String eCpf) {
		if(ValidacoesFuncionario.validaCpf(eCpf)) {
			this.cpf = eCpf;
			return true;
		}
		return false;
	}
	
	public String getCpf() {
		return this.cpf;
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
	
	
}
