package br.com.contmatic.empresa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.contmatic.validator.Validacoes;
import br.com.contmatic.validator.ValidacoesFuncionario;

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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", cargo=" + cargo
				+ ", salario=" + salario + "]";
	}
	
	
	
}
