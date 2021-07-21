package br.com.contmatic.empresa;

import br.com.contmatic.validator.ValidacaoTelefone;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static br.com.contmatic.validator.ValidacaoTelefone.validarDDD;
import static br.com.contmatic.validator.Validacoes.isNumeric;

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
        isNumeric(digitoPais);
        this.digitoPais = digitoPais;
    }

    public String getDigitoPais() {
        return this.digitoPais;
    }

    public void setDDD(DDD ddd) {
        this.ddd = ddd;
    }

    public DDD getDdd() {
        return this.ddd;
    }

    public void setTelefone(String telefone) {
        validacoesTelefone(telefone);
        this.numeroTelefone = telefone;
    }

    private void validacoesTelefone(String telefone) {
        isNumeric(telefone);
        if (telefone.length() != 9 && telefone.length() != 8) {
            throw new IllegalArgumentException("Quatidade de caracteres inseridas de maneira incorreta");
        }
    }

    public String getTelefone() {
        return this.numeroTelefone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
        result = prime * result + ((digitoPais == null) ? 0 : digitoPais.hashCode());
        result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
        return result;
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
