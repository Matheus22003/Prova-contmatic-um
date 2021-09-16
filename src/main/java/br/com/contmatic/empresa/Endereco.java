package br.com.contmatic.empresa;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static br.com.contmatic.constantes.EnderecoConstantes.*;
import static br.com.contmatic.constantes.Regex.SOMENTE_LETRAS;
import static br.com.contmatic.constantes.Regex.SOMENTE_NUMEROS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Endereco {

    @NotBlank(message = RUA_BLANK_MESSAGE)
    @Length(min = 5, max = 90, message = RUA_LENGTH_MESSAGE)
    @Pattern(regexp = SOMENTE_LETRAS, message = RUA_REGEX_MESSAGE)
    private String rua;

    @Range(min = 1, max = 99999, message = NUMERO_RANGE_MESSAGE)
    private Integer numero;

    @NotBlank(message = COMPLEMENTO_BLANK_MESSAGE)
    @Length(min = 2, max = 50, message = COMPLEMENTO_LENGTH_MESSAGE)
    private String complemento;

    @NotBlank(message = BAIRRO_BLANK_MESSAGE)
    @Pattern(regexp = SOMENTE_LETRAS, message = BAIRRO_REGEX_MESSAGE)
    @Length(max = 50, message = BAIRRO_LENGTH_MESSAGE)
    private String bairro;

    @NotNull(message = ESTADO_NULL_MESSAGE)
    private EstadosBrasil estado;

    @NotBlank(message = CIDADE_BLANK_MESSAGE)
    @Pattern(regexp = SOMENTE_LETRAS, message = CIDADE_REGEX_MESSAGE)
    @Length(max = 80, message = CIDADE_LENGTH_MESSAGE)
    private String cidade;

    @NotBlank(message = CEP_BLANK_MESSAGE)
    @Length(min = 8,max = 8, message = CEP_LENGTH_MESSAGE)
    @Pattern(regexp = SOMENTE_NUMEROS, message = CEP_REGEX_MESSAGE)
    private String cep;

    public Endereco(String cep, Integer numero) {
        this.setCep(cep);
        this.setNumero(numero);
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return this.rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setEstado(EstadosBrasil estado) {
        this.estado = estado;
    }

    public EstadosBrasil getEstado() {
        return this.estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return this.cep;
    }

    @Override
    public boolean equals(Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cep).append(numero).toHashCode();
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }
}
