package br.com.contmatic.empresa;

import java.util.ArrayList;
import java.util.List;

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

    public Empresa(String cnpj, Endereco endereco, String areaDeAtuacao) {
        this.setCnpj(cnpj);
        this.setEndereco(endereco);
        this.setAreaDeAtuacao(areaDeAtuacao);
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
        Empresa other = (Empresa) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (funcionarios.isEmpty()) {

            return "CNPJ: " + this.cnpj + "\n" + "Endere�o: " + this.endereco + "\n" + "Area de Atua��o: "
                    + areaDeAtuacao + "\n" + "Ainda n�o possui nenhum funcionario!";
        } else {
            return "CNPJ: " + this.cnpj + "\n" + "Endere�o: " + this.endereco + "\n" + "Quantidade de Funcionarios: "
                    + funcionarios.size() + "\n" + "Area de Atuação: " + areaDeAtuacao;

        }
    }

}
