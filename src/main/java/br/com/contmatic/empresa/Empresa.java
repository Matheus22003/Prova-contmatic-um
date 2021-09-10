package br.com.contmatic.empresa;

import br.com.contmatic.constantes.Regex;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Set;

import static br.com.contmatic.constantes.EmpresaConstantes.*;
import static br.com.contmatic.constantes.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Empresa {

    @NotBlank(message = NOME_BLANK_MESSAGE)
    @Length(min = 2, max = 100, message = NOME_LENGTH_MESSAGE)
    @Pattern(regexp = SOMENTE_LETRAS, message = NOME_REGEX_MESSAGE)
    private String nome;

    @NotEmpty(message = NOME_FANTASIA_EMPTY_MESSAGE)
    @Length(min = 2, max = 70, message = NOME_FANTASIA_LENGTH_MESSAGE)
    private String nomeFantasia;

    @NotNull(message = CNPJ_NULL_MESSAGE)
    @CNPJ(message = CNPJ_INVALID_MESSAGE)
    private String cnpj;

    @NotBlank(message = RAZAO_SOCIAL_BLANK_MESSAGE)
    @Length(min = 5, max = 60, message = RAZAO_SOCIAL_LENGTH_MESSAGE)
    @Pattern(regexp = SOMENTE_LETRAS, message = RAZAO_SOCIAL_REGEX_MESSAGE)
    private String razaoSocial;

    @NotBlank(message = AREA_DE_ATUACAO_BLANK_MESSAGE)
    @Size(min = 5, max = 60, message = AREA_DE_ATUACAO_SIZE_MESSAGE)
    @Pattern(regexp = SOMENTE_LETRAS, message = NOME_REGEX_MESSAGE)
    private String areaDeAtuacao;

    @NotEmpty(message = ENDERECOS_EMPTY_MESSAGE)
    @Valid
    private Set<Endereco> enderecos;

    @NotEmpty(message = FUNCIONARIOS_EMPTY_MESSAGE)
    @Valid
    private Set<Funcionario> funcionarios;

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

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
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
