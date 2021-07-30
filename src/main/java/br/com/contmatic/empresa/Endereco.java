package br.com.contmatic.empresa;

import br.com.contmatic.validator.Validacoes;

import javax.xml.validation.Validator;
import java.util.Objects;

import static br.com.contmatic.validator.Validacoes.*;

public class Endereco {

    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private EstadosBrasil estado;
    private String cidade;
    private String cep;

    public Endereco(String cep, int numero) {
        this.setCep(cep);
        this.setNumero(numero);
    }

    public void setRua(String rua) {
        isNonNumeric(rua, "br.com.contmatic.endereco");
        validarStringTamanhoMinimoEMaximo(rua, 5, 90, "br.com.contmatic.endereco");
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
        isStringEmpty(complemento);
        isStringBlank(complemento);
        validarStringTamanhoMaximo(complemento, 50);
        this.complemento = complemento;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setBairro(String bairro) {
        isStringEmpty(bairro, "br.com.contmatic.endereco");
        isStringBlank(bairro, "br.com.contmatic.endereco");
        isNonNumeric(bairro, "br.com.contmatic.endereco");
        validarStringTamanhoMaximo(bairro, 50, "br.com.contmatic.endereco");
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setEstado(EstadosBrasil estado) {
        verifierObjectIsNull(estado);
        this.estado = estado;
    }

    public EstadosBrasil getEstado() {
        return this.estado;
    }

    public void setCidade(String cidade) {
        isStringEmpty(cidade, "br.com.contmatic.endereco");
        isStringBlank(cidade, "br.com.contmatic.endereco");
        isNonNumeric(cidade, "br.com.contmatic.endereco");
        validarStringTamanhoMaximo(cidade, 50, "br.com.contmatic.endereco");
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCep(String cep) {
        isStringBlank(cep);
        isStringEmpty(cep);
        isNumeric(cep);
        validarStringTamanhoExatoCaracteres(cep, 8);
        this.cep = cep;
    }

    public String getCep() {
        return this.cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(numero, endereco.numero) && Objects.equals(cep, endereco.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, cep);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado=" + estado +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
