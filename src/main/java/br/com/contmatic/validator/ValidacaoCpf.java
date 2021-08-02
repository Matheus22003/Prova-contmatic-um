package br.com.contmatic.validator;

import static br.com.contmatic.validator.Validacoes.*;
import static java.lang.Integer.parseInt;

public final class ValidacaoCpf {
    private static final int CARACTERES_CPF = 11;
    private static final int NUM_CALCULAR_DIGITO_CPF_PRIMEIRO = 2;
    private static final int NUM_CALCULAR_DIGITO_CPF_SEGUNDO = 3;
    private static final int NUM_CALCULAR_DIGITO_CPF_TERCEIRO = 4;
    private static final int NUM_CALCULAR_DIGITO_CPF_QUARTO = 5;
    private static final int NUM_CALCULAR_DIGITO_CPF_QUINTO = 6;
    private static final int NUM_CALCULAR_DIGITO_CPF_SEXTO = 7;
    private static final int NUM_CALCULAR_DIGITO_CPF_SETIMO = 8;
    private static final int NUM_CALCULAR_DIGITO_CPF_OITAVO = 9;
    private static final int NUM_CALCULAR_DIGITO_CPF_NONO = 10;
    private static final int NUM_CALCULAR_DIGITO_CPF_DECIMO = 11;


    private ValidacaoCpf() {
    }

    public static void validaCpf(String cpf, String localizacaoClasse) {
        isStringBlank(cpf, localizacaoClasse);
        isStringEmpty(cpf, localizacaoClasse);
        isNumeric(cpf, localizacaoClasse);
        basicErrosCpf(cpf);
        int[] digitos = separetorDigitos(cpf);
        int digitoUm = getDigitoUm(digitos);
        int digitoDois = getDigitoDois(digitos, digitoUm);
        if (!(digitoUm == digitos[9] && digitoDois == digitos[10])) {
            throw new IllegalArgumentException("O CPF está invalido");
        }
    }

    private static void basicErrosCpf(String cpf) {
        if (basicErrorCpfVerifier(cpf)) {
            throw new IllegalArgumentException("O CPF está invalido");
        }
    }

    private static int[] separetorDigitos(String cpf) {
        int digitos[] = new int[CARACTERES_CPF];
        for (int i = 0; i < CARACTERES_CPF; i++) {
            digitos[i] = parseInt(cpf.split("")[i]);
        }
        return digitos;
    }

    private static int getDigitoDois(int[] digitos, int digitoUm) {
        int digitoDois = calculosParaDigitoDois(digitos, digitoUm);
        return digitoDois;
    }

    private static int calculosParaDigitoDois(int[] digitos, int digitoUm) {
        int digitoDois = (digitos[0] * NUM_CALCULAR_DIGITO_CPF_DECIMO) + (digitos[1] * NUM_CALCULAR_DIGITO_CPF_NONO) + (digitos[2] * NUM_CALCULAR_DIGITO_CPF_OITAVO) + (digitos[3] * NUM_CALCULAR_DIGITO_CPF_SETIMO) + (digitos[4] * NUM_CALCULAR_DIGITO_CPF_SEXTO)
                + (digitos[5] * NUM_CALCULAR_DIGITO_CPF_QUINTO) + (digitos[6] * NUM_CALCULAR_DIGITO_CPF_QUARTO) + (digitos[7] * NUM_CALCULAR_DIGITO_CPF_TERCEIRO) + (digitos[8] * NUM_CALCULAR_DIGITO_CPF_SEGUNDO) + (digitoUm * NUM_CALCULAR_DIGITO_CPF_PRIMEIRO);
        if (digitoDois % CARACTERES_CPF < 2) {
            digitoDois = 0;
        } else {
            digitoDois = CARACTERES_CPF - (digitoDois % CARACTERES_CPF);
        }
        return digitoDois;
    }

    private static int getDigitoUm(int[] digitos) {
        int digitoUm = calculoParaDigitoUm(digitos);
        return digitoUm;
    }

    private static int calculoParaDigitoUm(int[] digitos) {
        int digitoUm = (digitos[0] * NUM_CALCULAR_DIGITO_CPF_NONO) + (digitos[1] * NUM_CALCULAR_DIGITO_CPF_OITAVO) + (digitos[2] * NUM_CALCULAR_DIGITO_CPF_SETIMO) + (digitos[3] * NUM_CALCULAR_DIGITO_CPF_SEXTO) + (digitos[4] * NUM_CALCULAR_DIGITO_CPF_QUINTO)
                + (digitos[5] * NUM_CALCULAR_DIGITO_CPF_QUARTO) + (digitos[6] * NUM_CALCULAR_DIGITO_CPF_TERCEIRO) + (digitos[7] * NUM_CALCULAR_DIGITO_CPF_SEGUNDO) + (digitos[8] * NUM_CALCULAR_DIGITO_CPF_PRIMEIRO);
        if (digitoUm % CARACTERES_CPF < 2) {
            digitoUm = 0;
        } else {
            digitoUm = CARACTERES_CPF - (digitoUm % CARACTERES_CPF);
        }
        return digitoUm;
    }

    private static boolean basicErrorCpfVerifier(String cpf) {
        return cpf.length() != CARACTERES_CPF || cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999");
    }
}
