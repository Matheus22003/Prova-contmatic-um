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
        telefone = new Telefone(DDD.SAO_PAULO, "987704670");

    }

    @Test
    void testeGetDigitoPais() {
        assertThat("Erro ao adcionar DDD", telefone.getDigitoPais(), equalTo("55"));
    }

    @Test
    void testeAdicionarDDD() {
        telefone.setDDD(DDD.RIO_DE_JANEIRO);
        assertThat("Erro ao adcionar DDD", telefone.getDdd(), equalTo(DDD.RIO_DE_JANEIRO));
    }

    @Test
    void testeAdicionaDDDComErro() {
        assertThrows(IllegalArgumentException.class, () -> telefone.setDDD(DDD.valueOf("rwerwer")));
    }

    @Test
    void testeAdicionarTelefone() {
        telefone.setTelefone("960640102");
        assertThat("Erro ao adcionar Telefone", telefone.getTelefone(), equalTo("960640102"));
    }

    @Test
    void testeAdicionarTelefoneComErroDeQuatidadeAcima() {
        assertThrows(IllegalArgumentException.class, () -> telefone.setTelefone("960640102213123"));
    }

    @Test
    void testeAdicionarTelefoneComErroDeQuatidadeAbaixo() {
        assertThrows(IllegalArgumentException.class, () -> telefone.setTelefone("96064"));
    }

    @Test
    void testeHashCode() {
        Telefone telefoneHashCode = new Telefone(DDD.SAO_PAULO, "987704670");
        assertThat("Erro ao adcionar Telefone", telefoneHashCode.hashCode(), equalTo(-2124442984));
    }

    @Test
    void testeEquals() {
        Telefone telefoneDois = new Telefone(DDD.SAO_PAULO, "987704670");
        telefone = new Telefone(DDD.SAO_PAULO, "987704670");
        assertThat("Erro ao adcionar Telefone", telefone.equals(telefoneDois), equalTo(true));
    }

    @Test
    void testeEqualsEntreTelefonesDiferentes() {
        Telefone telefoneDois = new Telefone(DDD.RIO_DE_JANEIRO, "987704670");
        telefone = new Telefone(DDD.SAO_PAULO, "987704670");
        assertThat("Erro ao adcionar Telefone", telefone.equals(telefoneDois), equalTo(false));
    }

    @Test
    void testeToString() {
        assertThat("Erro ao adcionar Telefone", telefone.toString(), equalTo("Telefone [digitoPais=55, ddd=SAO_PAULO, numeroTelefone=987704670]"));

    }

}