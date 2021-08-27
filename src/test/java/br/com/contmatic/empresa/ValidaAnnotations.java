package br.com.contmatic.empresa;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.validation.Validation.buildDefaultValidatorFactory;

public class ValidaAnnotations {

    private ValidaAnnotations() {
    }

    public static boolean returnAnnotationMsgError(Object yourObject, String msgErroEsperada) {
        Validator validador = buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> erros = validador.validate(yourObject);
        List<String> errosMsg = new ArrayList<>();
        erros.stream().forEach(t1 -> errosMsg.add(t1.getMessage()));
        for (String erros1 : errosMsg) {
            if (msgErroEsperada.equalsIgnoreCase(erros1)) {
                return true;
            }
        }
        return false;
    }

}
