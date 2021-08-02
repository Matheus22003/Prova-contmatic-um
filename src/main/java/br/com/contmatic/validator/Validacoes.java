package br.com.contmatic.validator;

import org.apache.commons.lang3.StringUtils;

public final class Validacoes {

    private Validacoes() {
    }

    public static void isNonNumeric(String str, String localizacaoClasse) {
        if (str.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Valor fornecido em, " + localizacaoClasse + ", contem numeros: " + str);
        }
    }

    public static void isNumeric(String str, String localizacaoClasse) {
        if (!str.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("Valor fornecido em, " + localizacaoClasse + " contem letras: " + str);
        }
    }

    public static void isStringEmpty(String srt, String localizacaoClasse) {
        if (StringUtils.isEmpty(srt))
            throw new IllegalArgumentException("Valor fornecido em, " + localizacaoClasse + "é nulo.");
    }

    public static void isStringBlank(String srt, String localizacaoClasse) {
        if (StringUtils.isAllBlank(srt))
            throw new IllegalArgumentException("Valor fornecido em, " + localizacaoClasse + " está em branco");
    }

    public static void validarStringTamanhoMinimoEMaximo(String str, Integer minimo, Integer maximo, String localizacaoClasse) {
        verifierValueMinimoAndMaximo(minimo, maximo, localizacaoClasse);
        validarStringTamanhoMaximo(str, maximo, localizacaoClasse);
        validarStringTamanhoMinimo(str, minimo, localizacaoClasse);
    }

    public static void validarStringTamanhoExatoCaracteres(String str, Integer tamaho, String localizacaoClasse) {
        if (str.length() != tamaho) {
            throw new IllegalArgumentException("A string em " + localizacaoClasse + " não contem o tamanho " + tamaho + " de caracteres: " + str);
        }
    }

    public static void verifierObjectIsNull(Object obj, String localizacaoClasse) {
        if (obj == null) {
            throw new NullPointerException("O Objeto em " + localizacaoClasse + " está nulo");
        }
    }

    private static void verifierValueMinimoAndMaximo(Integer minimo, Integer maximo, String localizacaoClasse) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("Valores de minimo e maximo em, " + localizacaoClasse + " incorretos :" + minimo + ", " + maximo);
        }
    }

    public static void validarStringTamanhoMinimo(String str, Integer minimo, String localizacaoClasse) {
        if (str.length() <= minimo) {
            throw new IllegalArgumentException("Tamanho de string em " + localizacaoClasse + " está abaixo de " + minimo + " caracteres");
        }
    }

    public static void validarStringTamanhoMaximo(String str, Integer maximo, String localizacaoClasse) {
        if (str.length() >= maximo) {
            throw new IllegalArgumentException("Tamanho de string em " + localizacaoClasse + " está acima de " + maximo + " caracteres");
        }
    }
}
