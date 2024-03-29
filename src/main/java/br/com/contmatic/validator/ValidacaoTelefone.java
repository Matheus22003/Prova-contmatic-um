package br.com.contmatic.validator;

import br.com.contmatic.empresa.DDD;

import static br.com.contmatic.validator.Validacoes.isNumeric;

public final class ValidacaoTelefone {
    private ValidacaoTelefone() {
    }

    private static Boolean verificarDDDExistente(String dddEnviado) {
        boolean existente = false;
        for (DDD ddd : DDD.values()) {
            if (ddd.getCodigoDDD() == Integer.parseInt(dddEnviado)) {
                existente = true;
                break;
            }
        }
        return existente;
    }

}
