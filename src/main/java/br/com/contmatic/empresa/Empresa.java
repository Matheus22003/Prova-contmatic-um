package br.com.contmatic.empresa;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.validator.Validacoes.*;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Empresa {

    @NotEmpty(message = "O nome não pode estar vazio.")
    @NotBlank(message = "O nome não pode estar em branco.")
    @Length(min = 2, max = 100, message = "Numero de caracteres de nome invalido.")
    private String nome;

    @NotEmpty(message = "O nomeFantasia não pode estar vazio.")
    @NotBlank(message = "O nomeFantasia não pode estar em branco.")
    @Length(min = 2, max = 70, message = "Numero de caracteres de nomeFantasia invalido.")
    private String nomeFantasia;

    @NotEmpty(message = "O CNPJ não pode estar vazio.")
    @NotNull(message = "O CNPJ não pode estar nulo.")
    @NotBlank(message = "O CNPJ não pode estar em branco.")
    @CNPJ(message = "CNPJ enviado invalido.")
    private String cnpj;

    @NotEmpty(message = "O razaoSocial não pode estar vazio.")
    @NotBlank(message = "O razaoSocial não pode estar em branco.")
    @Length(min = 5, max = 60, message = "Numero de caracteres de razaoSocial invalido.")
    private String razaoSocial;

    @NotEmpty(message = "O razaoSocial não pode estar vazio.")
    @NotBlank(message = "O razaoSocial não pode estar em branco.")
    @Size(min = 5, max = 60, message = "Numero de caracteres de razaoSocial invalido.")
    private String areaDeAtuacao;

    @NotEmpty(message = "O endereco não pode estar vazio.")
    @NotBlank(message = "O endereco não pode estar em branco.")
    @Valid
    private Endereco endereco;

    @Valid
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Empresa(String cnpj) {
        this.setCnpj(cnpj);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
//        isStringBlank(razaoSocial, "razaoSocial", "Empresa");
//        isStringEmpty(razaoSocial, "razaoSocial", "Empresa");
//        validarStringTamanhoMinimoEMaximo(razaoSocial, 5, 60, "razaoSocial", "Empresa");
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
