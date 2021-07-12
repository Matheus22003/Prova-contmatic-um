package br.com.contmatic.validator;

import static br.com.contmatic.validator.Validacoes.isNumeric;
import static br.com.contmatic.validator.Validacoes.isStringNull;

import br.com.contmatic.exception.CnpjInvalidoException;

public final class ValidatorEmpresa {

    private static final int CARACTERES_CNPJ = 14;

    private ValidatorEmpresa() {
    }

    public static void validaCnpj(String eCnpj) {
        isStringNull(eCnpj);
        isNumeric(eCnpj);
        verificaErrosBasicos(eCnpj);
        int digitos[] = new int[CARACTERES_CNPJ];
        int digitoUm = getDigitoUm(eCnpj, digitos);
        int digitoDois = getDigitoDois(digitos, digitoUm);
        verificaDigitosCnpj(digitos, digitoUm, digitoDois);
    }

    private static void verificaDigitosCnpj(int[] digitos, int digitoUm, int digitoDois) {
        if (!(digitos[12] == digitoUm && digitos[13] == digitoDois)) {
            throw new CnpjInvalidoException("O CNPJ está invalido");
        }
    }

    private static void verificaErrosBasicos(String eCnpj) {
        if (basicErrorCnpjVerifier(eCnpj)) {
            throw new CnpjInvalidoException("O CNPJ está invalido");
        }
    }

    private static int getDigitoDois(int[] digitos, int digitoUm) {
        int digitoDois = calcularDigitoDois(digitoUm, digitos);
        return digitoDois;
    }

    private static int calcularDigitoDois(int digitoUm, int[] digitos) {
        int digitoDois = digitoUm * 2 + digitos[11] * 3 + digitos[10] * 4 + digitos[9] * 5 + digitos[8] * 6
                + digitos[7] * 7 + digitos[6] * 8 + digitos[5] * 9 + digitos[4] * 2 + digitos[3] * 3 + digitos[2] * 4
                + digitos[1] * 5 + digitos[0] * 6;
        digitoDois = 11 - (div(digitoDois, 11));
        return digitoDois;
    }

    private static int getDigitoUm(String cnpj, int[] digitos) {
        separarDigitosDoCnpj(cnpj, digitos);
        int digitoUm = calclularDigitoUm(digitos);
        digitoUm = verificarDigitoUmEmDuasOpcoesAposCalculo(digitoUm);
        return digitoUm;
    }

    private static int verificarDigitoUmEmDuasOpcoesAposCalculo(int digitoUm) {
        if (digitoUm >= 10) {
            digitoUm = 0;
        }
        return digitoUm;
    }

    private static void separarDigitosDoCnpj(String cnpj, int[] digitos) {
        for (int i = 0; i < CARACTERES_CNPJ; i++) {
            digitos[i] = Integer.parseInt(cnpj.split("")[i]);
        }
    }

    private static int calclularDigitoUm(int[] digitos) {
        int digitoUm = digitos[11] * 2 + digitos[10] * 3 + digitos[9] * 4 + digitos[8] * 5 + digitos[7] * 6
                + digitos[6] * 7 + digitos[5] * 8 + digitos[4] * 9 + digitos[3] * 2 + digitos[2] * 3 + digitos[1] * 4
                + digitos[0] * 5;
        digitoUm = 11 - (div(digitoUm, 11));
        return digitoUm;
    }

    private static boolean basicErrorCnpjVerifier(String cnpj) {
        return cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
                || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
                || cnpj.equals("99999999999999") || (cnpj.length() != CARACTERES_CNPJ);
    }

    private static int div(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }
}
