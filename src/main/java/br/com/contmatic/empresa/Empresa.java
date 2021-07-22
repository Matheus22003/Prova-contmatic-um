package br.com.contmatic.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static br.com.contmatic.validator.Validacoes.*;
import static br.com.contmatic.validator.ValidatorEmpresa.validaCnpj;

public class Empresa {

    private String nome;
    private String nomeFantasia;
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
        validarStringTamanhoMinimoEMaximo(nome, 2, 100);
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        validarStringTamanhoMinimoEMaximo(nomeFantasia, 2, 70);
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validaCnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        validarStringTamanhoMinimoEMaximo(razaoSocial, 5, 60);
        this.razaoSocial = razaoSocial;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        isStringNull(areaDeAtuacao);
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        verifierObjectIsNull(funcionarios);
        this.funcionarios = funcionarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(cnpj, empresa.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public String toString() {
        if (funcionarios.isEmpty()) {

            return "CNPJ: " + this.cnpj + "\n" + "Endereço: " + this.endereco + "\n" + "Area de Atuação: "
                    + areaDeAtuacao + "\n" + "Ainda não possui nenhum funcionario!";
        } else {
            return "CNPJ: " + this.cnpj + "\n" + "Endereço: " + this.endereco + "\n" + "Quantidade de Funcionarios: "
                    + funcionarios.size() + "\n" + "Area de Atuação: " + areaDeAtuacao;

        }
    }

}
