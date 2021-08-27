package br.com.contmatic.empresa;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.validator.Validacoes.*;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Empresa {

    private String nome;

    private String nomeFantasia;

    @NotNull(message = "Funciona")
    @CNPJ(message = "Funciona")
    private String cnpj;

    private String razaoSocial;

    private String areaDeAtuacao;

    private Endereco endereco;

    private List<Funcionario> funcionarios = new ArrayList<>();

    public Empresa(String cnpj) {
        this.setCnpj(cnpj);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        isStringEmpty(nome, "nome", "Empresa");
        isStringBlank(nome, "nome", "Empresa");
        validarStringTamanhoMinimoEMaximo(nome, 2, 100, "nome", "Empresa");
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        isStringEmpty(nomeFantasia, "nomeFantasia", "Empresa");
        isStringBlank(nomeFantasia, "nomeFantasia", "Empresa");
        validarStringTamanhoMinimoEMaximo(nomeFantasia, 2, 70, "nomeFantasia", "Empresa");
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
//        validaCnpj(cnpj, "cnpj", "Empresa");
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        isStringBlank(razaoSocial, "razaoSocial", "Empresa");
        isStringEmpty(razaoSocial, "razaoSocial", "Empresa");
        validarStringTamanhoMinimoEMaximo(razaoSocial, 5, 60, "razaoSocial", "Empresa");
        this.razaoSocial = razaoSocial;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        isStringEmpty(areaDeAtuacao, "areaDeAtuacao", "Empresa");
        isStringBlank(areaDeAtuacao, "areaDeAtuacao", "Empresa");
        validarStringTamanhoMaximo(areaDeAtuacao, 90, "areaDeAtuacao", "Empresa");
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        verifierObjectIsNull(endereco, "endereco", "Endereco");
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        verifierObjectIsNull(funcionarios, "funcionarios", "Empresa");
        validarListIsEmpty(funcionarios, "funcionarios", "Empresa");
        validarListIsZero(funcionarios, "funcionarios", "Empresa");
        this.funcionarios = funcionarios;
    }

    @Override
    public boolean equals(Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this.cnpj);
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }

}
