package br.com.contmatic.validator;

import org.apache.commons.lang3.StringUtils;

public final class Validacoes {

    private Validacoes() {
    }

    public static void isNonNumeric(String str, String localizacaoClasse) {
        if (str.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Valor fornecido contem numeros");
        }
    }

    public static void isNumeric(String str, String localizacaoClasse) {
        if (!str.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("Valor fornecido contem letras");
        }
    }

    public static void isStringEmpty(String srt, String localizacaoClasse) {
        if (StringUtils.isEmpty(srt))
            throw new IllegalArgumentException("Valor fornecido nulo: " + srt);
    }

    public static void isStringBlank(String srt, String localizacaoClasse) {
        if (StringUtils.isAllBlank(srt))
            throw new IllegalArgumentException("Valor fornecido nulo: " + srt);
    }

    public static void validarStringTamanhoMinimoEMaximo(String str, Integer minimo, Integer maximo, String localizacaoClasse) {
        verifierValueMinimoAndMaximo(minimo, maximo);
        validarStringTamanhoMaximo(str, maximo);
        validarStringTamanhoMinimo(str, minimo);
    }

    public static void validarStringTamanhoExatoCaracteres(String str, Integer tamaho, String localizacaoClasse) {
        if (str.length() != tamaho) {
            throw new IllegalArgumentException("A string: " + str + ", não contem: " + tamaho + "caracteres.");
        }
    }

    public static void verifierObjectIsNull(Object obj, String localizacaoClasse) {
        if (obj == null) {
            throw new NullPointerException("O Objeto está nulo");
        }
    }

    private static void verifierValueMinimoAndMaximo(Integer minimo, Integer maximo, String localizacaoClasse) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("Valores de minimo e maximo incorretos :" + minimo + ", " + maximo);
        }
    }

    public static void validarStringTamanhoMinimo(String str, Integer minimo, String localizacaoClasse) {
        if (str.length() <= minimo) {
            throw new IllegalArgumentException("Tamanho de string está abaixo de " + minimo + " caracteres");
        }
    }

    public static void validarStringTamanhoMaximo(String str, Integer maximo, String localizacaoClasse) {
        if (str.length() >= maximo) {
            throw new IllegalArgumentException("Tamanho de string está acima de " + maximo + " caracteres");
        }
    }
}
