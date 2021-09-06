package br.com.contmatic.empresa;

import br.com.contmatic.constantes.EmpresaConstantes;
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

import static br.com.contmatic.constantes.EmpresaConstantes.*;
import static br.com.contmatic.validator.Validacoes.*;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Empresa {

    @NotEmpty(message = NOME_EMPTY_MESSAGE)
    @NotBlank(message = NOME_BLANK_MESSAGE)
    @Length(min = 2, max = 100, message = NOME_LENGTH_MESSAGE)
    private String nome;

    @NotEmpty(message = NOME_FANTASIA_EMPTY_MESSAGE)
    @NotBlank(message = NOME_FANTASIA_BLANK_MESSAGE)
    @Length(min = 2, max = 70, message = NOME_FANTASIA_LENGTH_MESSAGE)
    private String nomeFantasia;

    @NotEmpty(message = CNPJ_EMPTY_MESSAGE)
    @NotNull(message = CNPJ_NULL_MESSAGE)
    @NotBlank(message = CNPJ_BLANK_MESSAGE)
    @CNPJ(message = CNPJ_INVALID_MESSAGE)
    private String cnpj;

    @NotEmpty(message = RAZAO_SOCIAL_EMPTY_MESSAGE)
    @NotBlank(message = RAZAO_SOCIAL_BLANK_MESSAGE)
    @Length(min = 5, max = 60, message = RAZAO_SOCIAL_LENGTH_MESSAGE)
    private String razaoSocial;

    @NotEmpty(message = AREA_DE_ATUACAO_EMPTY_MESSAGE)
    @NotBlank(message = AREA_DE_ATUACAO_BLANK_MESSAGE)
    @Size(min = 5, max = 60, message = AREA_DE_ATUACAO_SIZE_MESSAGE)
    private String areaDeAtuacao;

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
        this.razaoSocial = razaoSocial;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
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
