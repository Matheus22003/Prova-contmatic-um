package br.com.contmatic.empresa;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import static br.com.contmatic.validator.Validacoes.*;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Endereco {

    private String rua;

    private Integer numero;

    private String complemento;

    private String bairro;

    private EstadosBrasil estado;

    private String cidade;

    private String cep;

    public Endereco(String cep, Integer numero) {
        this.setCep(cep);
        this.setNumero(numero);
    }

    public void setRua(String rua) {
        isNonNumeric(rua, "rua", "Endereco");
        validarStringTamanhoMinimoEMaximo(rua, 5, 90, "rua", "Endereco");
        this.rua = rua;
    }

    public String getRua() {
        return this.rua;
    }

    public void setNumero(int numero) {
        validarIntMinimoEmaximo(numero, 1, 99999, "numero", "Endereco");
        this.numero = numero;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setComplemento(String complemento) {
        isStringEmpty(complemento, "complemento", "Endereco");
        isStringBlank(complemento, "complemento", "Endereco");
        validarStringTamanhoMaximo(complemento, 50, "complemento", "Endereco");
        this.complemento = complemento;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setBairro(String bairro) {
        isStringEmpty(bairro, "bairro", "Endereco");
        isStringBlank(bairro, "bairro", "Endereco");
        isNonNumeric(bairro, "bairro", "Endereco");
        validarStringTamanhoMaximo(bairro, 50, "bairro", "Endereco");
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setEstado(EstadosBrasil estado) {
        verifierObjectIsNull(estado, "estado", "Endereco");
        this.estado = estado;
    }

    public EstadosBrasil getEstado() {
        return this.estado;
    }

    public void setCidade(String cidade) {
        isStringEmpty(cidade, "cidade", "Endereco");
        isStringBlank(cidade, "cidade", "Endereco");
        isNonNumeric(cidade, "cidade", "Endereco");
        validarStringTamanhoMaximo(cidade, 80, "cidade", "Endereco");
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCep(String cep) {
        isStringBlank(cep, "cep", "Endereco");
        isStringEmpty(cep, "cep", "Endereco");
        isNumeric(cep, "cep", "Endereco");
        validarStringTamanhoExatoCaracteres(cep, 8, "cep", "Endereco");
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
