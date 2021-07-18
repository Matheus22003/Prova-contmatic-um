package br.com.contmatic.empresa;

import br.com.contmatic.validator.Validacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static br.com.contmatic.validator.Validacoes.isNonNumeric;
import static br.com.contmatic.validator.ValidacaoCpf.validaCpf;
import static br.com.contmatic.validator.Validacoes.validarStringTamanhoMaximo;

public class Funcionario {

    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String cargo;
    private double salario;

    public Funcionario(String cpf) {
        this.setCpf(cpf);
    }

    public void setNome(String nome) {
        isNonNumeric(nome);
        validarStringTamanhoMaximo(nome, 80);
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setCpf(String cpf) {
        validaCpf(cpf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCargo(String cargo) {
        isNonNumeric(cargo);
        this.cargo = cargo;
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
        } else
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
