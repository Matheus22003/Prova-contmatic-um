package br.com.contmatic.empresa;

import java.util.Objects;

import static br.com.contmatic.validator.Validacoes.*;

public class Telefone {

    String digitoPais;
    DDD ddd;
    String numeroTelefone;

    public Telefone(DDD ddd, String telefone) {
        this.setDigitoPais("55");
        this.setDDD(ddd);
        this.setTelefone(telefone);
    }

    private void setDigitoPais(String digitoPais) {
        isStringEmpty(digitoPais, "br.com.contmatic.Telefone.setDigitoPais()");
        isStringBlank(digitoPais, "br.com.contmatic.Telefone.setDigitoPais()");
        isNumeric(digitoPais, "br.com.contmatic.Telefone.setDigitoPais()");
        this.digitoPais = digitoPais;
    }

    public String getDigitoPais() {
        return this.digitoPais;
    }

    public void setDDD(DDD ddd) {
        verifierObjectIsNull(ddd, "br.com.contmatic.Telefone.setDDD()");
        this.ddd = ddd;
    }

    public DDD getDdd() {
        return this.ddd;
    }

    public void setTelefone(String telefone) {
        validacoesTelefone(telefone, "br.com.contmatic.Telefone.setTelefone.validacoesTelefone()");
        this.numeroTelefone = telefone;
    }

    private void validacoesTelefone(String telefone, String localizacaoClasse) {
        isStringEmpty(telefone, localizacaoClasse);
        isStringBlank(telefone, localizacaoClasse);
        isNumeric(telefone, localizacaoClasse);
        if (telefone.length() != 9 && telefone.length() != 8) {
            throw new IllegalArgumentException("Quatidade de caracteres inseridas(" + telefone + ") de maneira incorreta no: " + localizacaoClasse);
        }
    }

    public String getTelefone() {
        return this.numeroTelefone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitoPais, ddd, numeroTelefone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(digitoPais, telefone.digitoPais) && ddd == telefone.ddd && Objects.equals(numeroTelefone, telefone.numeroTelefone);
    }

    @Override
    public String toString() {
        return "Telefone [digitoPais=" + digitoPais + ", ddd=" + ddd + ", numeroTelefone=" + numeroTelefone + "]";
    }

}
