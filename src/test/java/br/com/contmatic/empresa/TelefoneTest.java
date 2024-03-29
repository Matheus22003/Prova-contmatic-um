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
    void deve_recuperar_ddd() {
        assertThat("Erro ao adcionar DDD", telefone.getDigitoPais(), equalTo("55"));
    }

    @Test
    void deve_aceitar_ddd_valido() {
        telefone.setDDD(DDD.RIO_DE_JANEIRO);
        assertThat("Erro ao adcionar DDD", telefone.getDdd(), equalTo(DDD.RIO_DE_JANEIRO));
    }

    @Test
    void nao_deve_aceitar_ddd_inexistente() {
        assertThrows(IllegalArgumentException.class, () -> telefone.setDDD(DDD.valueOf("rwerwer")));
    }

    @Test
    void deve_aceitar_telefone_valido() {
        telefone.setTelefone("960640102");
        assertThat("Erro ao adcionar Telefone", telefone.getTelefone(), equalTo("960640102"));
    }

    @Test
    void nao_deve_aceitar_um_numero_contendo_mais_de_9_caracteres() {
        assertThrows(IllegalArgumentException.class, () -> telefone.setTelefone("960640102213123"));
    }

    @Test
    void nao_deve_aceitar_um_nome_contendo_menos_de_9_ou_8_caracteres() {
        assertThrows(IllegalArgumentException.class, () -> telefone.setTelefone("96064"));
    }

    @Test
    void deve_mostrar_esse_exato_hashcode() {
        Telefone telefoneHashCode = new Telefone(DDD.SAO_PAULO, "987704670");
        assertThat("Erro ao adcionar Telefone", telefoneHashCode.hashCode(), equalTo(-1904239072));
    }

    @Test
    void deve_mostrar_que_os_dois_telefones_de_numero_ddd_iguais_sao_os_mesmas() {
        Telefone telefoneDois = new Telefone(DDD.SAO_PAULO, "987704670");
        telefone = new Telefone(DDD.SAO_PAULO, "987704670");
        assertThat("Erro ao adcionar Telefone", telefone.equals(telefoneDois), equalTo(true));
    }

    @Test
    void deve_mostrar_que_os_dois_telefones_de_numero_ddd_diferentes_nao_sao_os_mesmos() {
        Telefone telefoneDois = new Telefone(DDD.RIO_DE_JANEIRO, "987704670");
        telefone = new Telefone(DDD.SAO_PAULO, "987704670");
        assertThat("Erro ao adcionar Telefone", telefone.equals(telefoneDois), equalTo(false));
    }

    @Test
    void deve_retornar_string() {
        assertThat("Erro ao adcionar Telefone", telefone.toString(), equalTo("Telefone [digitoPais=55, ddd=SAO_PAULO, numeroTelefone=987704670]"));

    }

}