package br.com.contmatic.validator;

import static br.com.contmatic.validator.Validacoes.isNumeric;
import static br.com.contmatic.validator.Validacoes.isStringEmpty;
import static java.lang.Integer.parseInt;
import static java.lang.Math.floor;
import static java.lang.Math.round;

import br.com.contmatic.exception.CnpjInvalidoException;

public final class ValidatorEmpresa {

    private static final int CARACTERES_CNPJ = 14;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_PRIMEIRO = 2;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_SEGUNDO = 3;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_TERCEIRO = 4;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_QUARTO = 5;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_QUINTO = 6;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_SEXTO = 7;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_SETIMO = 8;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_OITAVO = 9;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_NONO = 2;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_DECIMO = 3;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_DECIMO_PRIMEIRO = 4;
    private static final int NUM_CALCULAR_DIGITO_CNPJ_DECIMO_SEGUNDO = 5;
    private static final int VERIFICADOR_PARA_DIGITO_UM_APOS_CALCULO = 10;
    private static final int VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS = 11;

    private ValidatorEmpresa() {
    }

    public static void validaCnpj(String cnpj, String localizacaoClasse) {
        isStringEmpty(cnpj, localizacaoClasse);
        isNumeric(cnpj, localizacaoClasse);
        verificaErrosBasicos(cnpj);
        int digitos[] = new int[CARACTERES_CNPJ];
        int digitoUm = getDigitoUm(cnpj, digitos);
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
        int digitoDois = digitoUm * NUM_CALCULAR_DIGITO_CNPJ_PRIMEIRO + digitos[11] * NUM_CALCULAR_DIGITO_CNPJ_SEGUNDO + digitos[10] * NUM_CALCULAR_DIGITO_CNPJ_TERCEIRO + digitos[9] * NUM_CALCULAR_DIGITO_CNPJ_QUARTO + digitos[8] * NUM_CALCULAR_DIGITO_CNPJ_QUINTO
                + digitos[7] * NUM_CALCULAR_DIGITO_CNPJ_SEXTO + digitos[6] * NUM_CALCULAR_DIGITO_CNPJ_SETIMO + digitos[5] * NUM_CALCULAR_DIGITO_CNPJ_OITAVO + digitos[4] * NUM_CALCULAR_DIGITO_CNPJ_PRIMEIRO + digitos[3] * NUM_CALCULAR_DIGITO_CNPJ_SEGUNDO + digitos[2] * NUM_CALCULAR_DIGITO_CNPJ_TERCEIRO
                + digitos[1] * NUM_CALCULAR_DIGITO_CNPJ_QUARTO + digitos[0] * NUM_CALCULAR_DIGITO_CNPJ_QUINTO;
        digitoDois = VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS - (div(digitoDois, VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS));
        return digitoDois;
    }

    private static int getDigitoUm(String cnpj, int[] digitos) {
        separarDigitosDoCnpj(cnpj, digitos);
        int digitoUm = calclularDigitoUm(digitos);
        digitoUm = verificarDigitoUmEmDuasOpcoesAposCalculo(digitoUm);
        return digitoUm;
    }

    private static int verificarDigitoUmEmDuasOpcoesAposCalculo(int digitoUm) {
        if (digitoUm >= VERIFICADOR_PARA_DIGITO_UM_APOS_CALCULO) {
            digitoUm = 0;
        }
        return digitoUm;
    }

    private static void separarDigitosDoCnpj(String cnpj, int[] digitos) {
        for (int i = 0; i < CARACTERES_CNPJ; i++) {
            digitos[i] = parseInt(cnpj.split("")[i]);
        }
    }

    private static int calclularDigitoUm(int[] digitos) {
        int digitoUm = digitos[11] * NUM_CALCULAR_DIGITO_CNPJ_PRIMEIRO + digitos[10] * NUM_CALCULAR_DIGITO_CNPJ_SEGUNDO + digitos[9] * NUM_CALCULAR_DIGITO_CNPJ_TERCEIRO + digitos[8] * NUM_CALCULAR_DIGITO_CNPJ_QUARTO + digitos[7] * NUM_CALCULAR_DIGITO_CNPJ_QUINTO
                + digitos[6] * NUM_CALCULAR_DIGITO_CNPJ_SEXTO + digitos[5] * NUM_CALCULAR_DIGITO_CNPJ_SETIMO + digitos[4] * NUM_CALCULAR_DIGITO_CNPJ_OITAVO + digitos[3] * NUM_CALCULAR_DIGITO_CNPJ_NONO + digitos[2] * NUM_CALCULAR_DIGITO_CNPJ_DECIMO + digitos[1] * NUM_CALCULAR_DIGITO_CNPJ_DECIMO_PRIMEIRO
                + digitos[0] * NUM_CALCULAR_DIGITO_CNPJ_DECIMO_SEGUNDO;
        digitoUm = VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS - (div(digitoUm, VALOR_ABAIXO_DOS_PRIMEIROS_CARACTERES_SEM_DIGITOS));
        return digitoUm;
    }

    private static boolean basicErrorCnpjVerifier(String cnpj) {
        return cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
                || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
                || cnpj.equals("99999999999999") || (cnpj.length() != CARACTERES_CNPJ);
    }

    private static int div(int dividendo, int divisor) {
        return (int) round(dividendo - (floor(dividendo / divisor) * divisor));
    }
}
