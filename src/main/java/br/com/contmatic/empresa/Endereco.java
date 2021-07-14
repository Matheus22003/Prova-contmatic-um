package br.com.contmatic.empresa;

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

    public Endereco(String rua, int numero, String complemento, String bairro, EstadosBrasil estado, String cidade,
                    String cep) {
        this.setRua(rua);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setEstado(estado);
        this.setCidade(cidade);
        this.setCep(cep);
    }

    public void setRua(String rua) {
        isNonNumeric(rua);
        validarStringTamanhoMinimoEMaximo(rua, 5, 90);
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
        validarStringTamanhoMaximo(complemento, 50);
        this.complemento = complemento;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setBairro(String bairro) {
        isNonNumeric(bairro);
        validarStringTamanhoMaximo(bairro, 50);
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setEstado(EstadosBrasil estado) {
        estadoIsEmpty(estado);
        this.estado = estado;
    }

    public EstadosBrasil getEstado() {
        return this.estado;
    }

    private void estadoIsEmpty(EstadosBrasil estado) {
        if (estado == null) {
            throw new NullPointerException("O estado esta vazio");
        }
    }

    public void setCidade(String cidade) {
        isNonNumeric(cidade);
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCep(String cep) {
        isNumeric(cep);
        if (cep.length() != 8) {
            throw new ExceptionInInitializerError("Numero de caracteres invalido");
        }
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
        return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + "]";
    }

}
