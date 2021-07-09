package br.com.contmatic.validator;

public final class Validacoes {

    private Validacoes() {
    }

    public static void isNonNumeric(String str) {
        isStringNull(str);
        if (str.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Valor fornecido contem numeros");
        }
    }

    public static void isNumeric(String str) {
        isStringNull(str);
        if (!str.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("Valor fornecido contem letras");
        }
    }

    public static void isStringNull(String srt) {
        if (srt == null || srt.isEmpty())
            throw new IllegalArgumentException("Valor fornecido nulo");
    }

    public static void validarStringTamanhoMinimoEMaximo(String str, Integer minimo, Integer maximo) {
        verifierValueMinimoAndMaximo(minimo, maximo);
        validarStringTamanhoMaximo(str, maximo);
        validarStringTamanhoMinimo(str, minimo);
    }

    public static void verifierObjectIsNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("O Objeto está nulo");
        }
    }

    private static void verifierValueMinimoAndMaximo(Integer minimo, Integer maximo) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("Valores de minimo e maximo incorretos :" + minimo + ", " + maximo);
        }
    }

    public static void validarStringTamanhoMinimo(String str, Integer minimo) {
        isStringNull(str);
        if (str.length() <= minimo) {
            throw new IllegalArgumentException("Tamanho de string está abaixo de " + minimo + " caracteres");
        }
    }

    public static void validarStringTamanhoMaximo(String str, Integer maximo) {
        isStringNull(str);
        if (str.length() >= maximo) {
            throw new IllegalArgumentException("Tamanho de string está acima de " + maximo + " caracteres");
        }
    }
}
