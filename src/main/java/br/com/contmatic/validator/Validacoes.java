package br.com.contmatic.validator;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class Validacoes {

    private Validacoes() {
    }

    public static void isNonNumeric(String str, String nomeDoCampo, String classe) {
        if (str.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O " + nomeDoCampo + " do " + classe + " não deve conter numeros.");
        }
    }

    public static void isNumeric(String str, String nomeDoCampo, String classe) {
        if (!str.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("O " + nomeDoCampo + " do " + classe + " não deve conter letras.");
        }
    }

    public static void isStringEmpty(String srt, String nomeDoCampo, String classe) {
        if (StringUtils.isEmpty(srt))
            throw new IllegalArgumentException("O " + nomeDoCampo + " do " + classe + " não deve ser vazio.");
    }

    public static void isStringBlank(String srt, String nomeDoCampo, String classe) {
        if (StringUtils.isAllBlank(srt))
            throw new IllegalArgumentException("O " + nomeDoCampo + " do " + classe + " não deve estar em branco.");
    }

    public static void validarStringTamanhoMinimoEMaximo(String str, Integer minimo, Integer maximo, String nomeDoCampo, String classe) {
        verifierValueMinimoAndMaximo(minimo, maximo, nomeDoCampo, classe);
        validarStringTamanhoMaximo(str, maximo, nomeDoCampo, classe);
        validarStringTamanhoMinimo(str, minimo, nomeDoCampo, classe);
    }

    public static void validarStringTamanhoExatoCaracteres(String str, Integer tamaho, String nomeDoCampo, String classe) {
        if (str.length() != tamaho) {
            throw new IllegalArgumentException("O " + nomeDoCampo + " do " + classe + " deve conter " + tamaho + " caracteres.");
        }
    }

    public static void verifierObjectIsNull(Object obj, String nomeDoCampo, String classe) {
        if (obj == null) {
            throw new NullPointerException("O Objeto " + nomeDoCampo + " em " + classe + " está nulo");
        }
    }

    private static void verifierValueMinimoAndMaximo(Integer minimo, Integer maximo, String nomeDoCampo, String classe) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("Valores de minimo e maximo em, " + nomeDoCampo + ", " + classe + " estão incorretos :" + minimo + ", " + maximo);
        }
    }

    public static void validarStringTamanhoMinimo(String str, Integer minimo, String nomeDoCampo, String classe) {
        if (str.length() <= minimo) {
            throw new IllegalArgumentException("Tamanho de string " + nomeDoCampo + " em " + classe + " está abaixo de " + minimo + " caracteres");
        }
    }

    public static void validarStringTamanhoMaximo(String str, Integer maximo, String nomeDoCampo, String classe) {
        if (str.length() >= maximo) {
            throw new IllegalArgumentException("Tamanho de string " + nomeDoCampo + " em " + classe + " está acima de " + maximo + " caracteres");
        }
    }

    public static void validarIntMinimoEmaximo(int numero, int minimo, int maximo, String nomeDoCampo, String classe) {
        validarIntMinimo(numero, minimo, nomeDoCampo, classe);
        validarIntMaximo(numero, maximo, nomeDoCampo, classe);
    }

    public static void validarIntMinimo(int numero, int minimo, String nomeDoCampo, String classe) {
        if (numero < minimo) {
            throw new IllegalArgumentException("Valor do " + nomeDoCampo + " na classe " + classe + " está baixo de " + minimo);
        }
    }

    public static void validarIntMaximo(int numero, int maximo, String nomeDoCampo, String classe) {
        if (numero > maximo) {
            throw new IllegalArgumentException("Valor do " + nomeDoCampo + " na classe " + classe + " está acima de " + maximo);
        }
    }

    public static void validarDate(Date data, String nomeDoCampo, String classe) {
        Date dataAtual = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (dataAtual.compareTo(data) < 0) {
            throw new IllegalStateException("A data do " + nomeDoCampo + " na classe " + classe + " está no futuro: " + sdf.format(data));
        }
    }

    public static void validarListIsEmpty(List<?> lista, String nomeDoCampo, String classe) {
        if (lista.isEmpty()) {
            throw new IllegalStateException("A list do " + nomeDoCampo + " na classe " + classe + " está no vazia: " + lista);
        }
    }

    public static void validarListIsZero(List<?> lista, String nomeDoCampo, String classe) {
        if (lista.size() <= 0) {
            throw new IllegalStateException("A list do " + nomeDoCampo + " na classe " + classe + " está no vazia: " + lista);
        }
    }

}



