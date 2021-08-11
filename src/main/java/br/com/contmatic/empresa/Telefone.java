package br.com.contmatic.empresa;

import java.util.Objects;

import static br.com.contmatic.validator.Validacoes.*;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class Telefone {

    private String digitoPais;

    private DDD ddd;

    private String numero;

    public Telefone(DDD ddd, String telefone) {
        this.setDigitoPais("55");
        this.setDDD(ddd);
        this.setTelefone(telefone);
    }

    private void setDigitoPais(String digitoPais) {
        isStringEmpty(digitoPais, "digitoPais", "Telefone");
        isStringBlank(digitoPais, "digitoPais", "Telefone");
        isNumeric(digitoPais, "digitoPais", "Telefone");
        this.digitoPais = digitoPais;
    }

    public String getDigitoPais() {
        return this.digitoPais;
    }

    public void setDDD(DDD ddd) {
        verifierObjectIsNull(ddd, "ddd", "Telefone");
        this.ddd = ddd;
    }

    public DDD getDdd() {
        return this.ddd;
    }

    public void setTelefone(String telefone) {
        validacoesTelefone(telefone, "digitoPais", "Telefone");
        this.numero = telefone;
    }

    private void validacoesTelefone(String telefone, String nomeDoCampo, String classe) {
        isStringEmpty(telefone, nomeDoCampo, classe);
        isStringBlank(telefone, nomeDoCampo, classe);
        isNumeric(telefone, nomeDoCampo, classe);
        if (telefone.length() != 9 && telefone.length() != 8) {
            throw new IllegalArgumentException("Quatidade de caracteres inseridas(" + telefone + ") de maneira incorreta no campo:  " + nomeDoCampo + " na classe " + classe);
        }
    }

    public String getTelefone() {
        return this.numero;
    }

    @Override
    public boolean equals(Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }

}
