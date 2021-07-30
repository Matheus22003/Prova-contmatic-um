package br.com.contmatic.empresa;

import br.com.contmatic.validator.Validacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static br.com.contmatic.validator.ValidacaoCpf.validaCpf;
import static br.com.contmatic.validator.Validacoes.*;

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
        isStringEmpty(nome, "br.com.contmatic.endereco");
        isStringBlank(nome, "br.com.contmatic.endereco");
        isNonNumeric(nome, "br.com.contmatic.endereco");
        validarStringTamanhoMaximo(nome, 80, "br.com.contmatic.endereco");
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        verifierObjectIsNull(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setCpf(String cpf) {
        isStringEmpty(cpf);
        isStringBlank(cpf);
        validaCpf(cpf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCargo(String cargo) {
        isStringEmpty(cargo, "br.com.contmatic.endereco");
        isStringBlank(cargo, "br.com.contmatic.endereco");
        isNonNumeric(cargo, "br.com.contmatic.endereco");
        validarStringTamanhoMaximo(cargo, 90, "br.com.contmatic.endereco");
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
            throw new IllegalArgumentException("Salário abaixo do mínimo");
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return cpf.equals(that.cpf);
    }

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", cargo=" + cargo
                + ", salario=" + salario + "]";
    }

}
