package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelefoneTest {

    Telefone telefone;

    @BeforeEach
    void setup() {
        telefone = new Telefone("11", "987704670");

    }

    @Test
    void testeCriacaoCompletaTelefone() {
        assertThat("CPF inserido incorretamente", telefone.getDdd(), equalTo("11"));
        assertThat("CPF inserido incorretamente", telefone.getTelefone(), equalTo("987704670"));
    }

    @Test
    void testeCriacaoComErroTelefone() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("900", "50806019"));
    }

}
