package br.com.contmatic.empresa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import java.util.Date;

import static br.com.contmatic.validator.ValidacaoCpf.validaCpf;
import static br.com.contmatic.validator.Validacoes.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Funcionario {

    private String nome;

    private DateTime dataNascimento;

    private String cpf;

    private String cargo;

    private double salario;

    public Funcionario(String cpf) {
        this.setCpf(cpf);
    }

    public void setNome(String nome) {
        isStringEmpty(nome, "nome", "Funcionario");
        isStringBlank(nome, "nome", "Funcionario");
        isNonNumeric(nome, "nome", "Funcionario");
        validarStringTamanhoMaximo(nome, 80, "nome", "Funcionario");
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDataNascimento(DateTime dataNascimento) {
        verifierObjectIsNull(dataNascimento, "dataNascimento", "Funcionario");
        this.dataNascimento = dataNascimento;
    }

    public DateTime getDataNascimento() {
        return this.dataNascimento;
    }

    public void setCpf(String cpf) {
        validaCpf(cpf, "cpf", "Funcionario");
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCargo(String cargo) {
        isStringEmpty(cargo, "cargo", "Funcionario");
        isStringBlank(cargo, "cargo", "Funcionario");
        isNonNumeric(cargo, "cargo", "Funcionario");
        validarStringTamanhoMaximo(cargo, 90, "cargo", "Funcionario");
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setSalario(double salario) {
        validaSalario(salario);
        this.salario = salario;
    }

    private void validaSalario(double salario) {
        if (!(salario >= 1100.00)) {
            throw new IllegalArgumentException("Salário abaixo do mínimo(1100.00): " + salario);
        }
    }

    public double getSalario() {
        return this.salario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Funcionario other = (Funcionario) obj;
        return new EqualsBuilder().append(cpf, other.cpf).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cpf).toHashCode();
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }

}
