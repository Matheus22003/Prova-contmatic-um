package br.com.contmatic.empresa;

import static br.com.contmatic.constantes.EmpresaConstantes.NOME_LENGTH_MESSAGE;
import static br.com.contmatic.constantes.EnderecoConstantes.*;
import static br.com.contmatic.empresa.ValidaAnnotations.returnAnnotationMsgError;
import static br.com.contmatic.fixture.factory.constantes.TiposFixtureFactoryEmpresa.VALIDO;
import static br.com.contmatic.fixture.factory.constantes.TiposFixtureFactoryEndereco.*;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnderecoTest {

    Endereco enderecoRivals;

    @BeforeAll
    public static void setupTest() {
        loadTemplates("br.com.contmatic.fixture.factory");
    }

    @BeforeEach
    void setup() {
        enderecoRivals = from(Endereco.class).gimme(VALIDO);
    }

    @Test
    void deve_aceitar_rua_valida() {
        assertThat("falha ao adicionar Rua", enderecoRivals.getRua(), equalTo("Rua Vergueiro"));
    }

    // Rua
    @Test
    void nao_deve_aceitar_uma_rua_com_valor_blank() {
        enderecoRivals = from(Endereco.class).gimme(RUA_WITH_BLANK_VALUE);
        assertThat("Erro ao adiconar valor em rua",
                returnAnnotationMsgError(enderecoRivals, RUA_BLANK_MESSAGE),
                equalTo(true));
    }

    @Test
    void nao_deve_aceitar_uma_rua_com_quantidade_de_caracteres_abaixo_de_5() {
        enderecoRivals = from(Endereco.class).gimme(RUA_WITHOUT_MIN_CHARACTERS);
        assertThat("Erro ao adiconar valor em rua",
                returnAnnotationMsgError(enderecoRivals, RUA_LENGTH_MESSAGE),
                equalTo(true));
    }

    @Test
    void nao_deve_aceitar_uma_rua_com_quantidade_de_caracteres_abaixo_de_90() {
        enderecoRivals = from(Endereco.class).gimme(RUA_WITH_MAX_CHARACTERS);
        assertThat("Erro ao adiconar valor em rua",
                returnAnnotationMsgError(enderecoRivals, RUA_LENGTH_MESSAGE),
                equalTo(true));
    }

    @Test
    void nao_deve_aceitar_uma_rua_contendo_numeros() {
        enderecoRivals = from(Endereco.class).gimme(RUA_WITH_NUMERICS_CHARACTERS);
        assertThat("Erro ao adiconar valor em rua",
                returnAnnotationMsgError(enderecoRivals, RUA_REGEX_MESSAGE),
                equalTo(true));
    }

    //Numero

    @Test
    void deve_aceitar_numero_valida() {
        assertThat("falha ao adicionar Numero", enderecoRivals.getNumero(), equalTo(819));
    }

    @Test
    void nao_deve_aceitar_um_numero_sendo_menor_que_1() {
        enderecoRivals = from(Endereco.class).gimme(NUMERO_WITHOUT_MIN_CHARACTERS);
        assertThat("Erro ao adiconar valor em numero",
                returnAnnotationMsgError(enderecoRivals, NUMERO_RANGE_MESSAGE),
                equalTo(true));
    }


    @Test
    void nao_deve_aceitar_um_numero_sendo_maior_que_99999() {
        enderecoRivals = from(Endereco.class).gimme(NUMERO_WITH_MAX_CHARACTERS);
        assertThat("Erro ao adiconar valor em numero",
                returnAnnotationMsgError(enderecoRivals, NUMERO_RANGE_MESSAGE),
                equalTo(true));
    }

    //Complemento
    @Test
    void deve_aceitar_complemento_valido() {
        assertThat("falha ao adicionar complemento", enderecoRivals.getComplemento(), equalTo("apto29"));
    }

    @Test
    void nao_deve_aceitar_um_complemento_com_valor_blank() {
        enderecoRivals = from(Endereco.class).gimme(COMPLEMENTO_WITH_BLANK_VALUE);
        assertThat("Erro ao adiconar valor em rua",
                returnAnnotationMsgError(enderecoRivals, COMPLEMENTO_BLANK_MESSAGE),
                equalTo(true));
    }

    @Test
    void nao_deve_aceitar_uma_complemento_contendo_menos_de_2_caracteres() {
        enderecoRivals = from(Endereco.class).gimme(COMPLEMENTO_WITHOUT_MIN_CHARACTERS);
        assertThat("Erro ao adiconar valor em numero",
                returnAnnotationMsgError(enderecoRivals, COMPLEMENTO_LENGTH_MESSAGE),
                equalTo(true));
    }

    @Test
    void nao_deve_aceitar_uma_complemento_contendo_mais_de_50_caracteres() {
        enderecoRivals = from(Endereco.class).gimme(NUMERO_WITH_MAX_CHARACTERS);
        assertThat("Erro ao adiconar valor em numero",
                returnAnnotationMsgError(enderecoRivals, NUMERO_RANGE_MESSAGE),
                equalTo(true));
    }

    //Bairro

    @Test
    void deve_aceitar_bairro_valido() {
        assertThat("falha ao adicionar bairro", enderecoRivals.getBairro(), equalTo("Liberdade"));
    }

    @Test
    void nao_deve_aceitar_um_bairro_com_valor_blank() {
        enderecoRivals = from(Endereco.class).gimme(BAIRRO_WITH_BLANK_VALUE);
        assertThat("Erro ao adiconar valor em bairro",
                returnAnnotationMsgError(enderecoRivals, BAIRRO_BLANK_MESSAGE),
                equalTo(true));
    }

    @Test
    void nao_deve_aceitar_um_bairro_contendo_numeros() {
        enderecoRivals = from(Endereco.class).gimme(BAIRRO_WITH_NUMERICS_CHARACTERS);
        assertThat("Erro ao adiconar valor em bairro",
                returnAnnotationMsgError(enderecoRivals, BAIRRO_REGEX_MESSAGE),
                equalTo(true));
    }

    @Test
    void nao_deve_aceitar_uma_bairro_contendo_mais_de_50_caracteres() {
        enderecoRivals = from(Endereco.class).gimme(BAIRRO_WITH_MAX_CHARACTERS);
        assertThat("Erro ao adiconar valor em bairro",
                returnAnnotationMsgError(enderecoRivals, BAIRRO_LENGTH_MESSAGE),
                equalTo(true));
    }

    //Estado
    @Test
    void deve_aceitar_estado_valido() {
        assertThat("falha ao adicionar Estado", enderecoRivals.getEstado(), equalTo(EstadosBrasil.SAOPAULO));
    }

    @Test
    void nao_deve_aceitar_um_estado_null() {
        enderecoRivals = from(Endereco.class).gimme(ESTADO_WITH_NULL_VALUE);
        assertThat("Erro ao adiconar valor em estado",
                returnAnnotationMsgError(enderecoRivals, ESTADO_NULL_MESSAGE),
                equalTo(true));
    }

    @Test
    void deve_aceitar_cidade_valido() {
        enderecoRivals.setCidade("São Paulo");
        assertThat("falha ao adicionar Cidade", enderecoRivals.getCidade(), equalTo("São Paulo"));
    }

    @Test
    void nao_deve_aceitar_uma_cidade_contendo_numeros() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCidade("00000"));
    }

    @Test
    void nao_deve_aceitar_uma_cidade_contendo_mais_de_80_caracteres() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCidade("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    void deve_aceitar_cep_valido() {
        enderecoRivals.setCep("01504001");
        assertThat("falha ao adicionar CEP", enderecoRivals.getCep(), equalTo("01504001"));
    }

    @Test
    void nao_deve_aceitar_um_cep_contendo_quantidade_de_caracteres_diferente_de_8() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCep("015040010"));
    }

    @Test
    void nao_deve_aceitar_um_cep_contendo_letras() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCep("aaaa00"));
    }

    @Test
    void deve_mostrar_que_os_dois_enderecos_de_mesmo_valores_sao_iguais() {
        Endereco endereco = from(Endereco.class).gimme(VALIDO);
        assertThat("falha ao calcular Equals", enderecoRivals.equals(endereco), equalTo(true));
    }

    @Test
    void deve_mostrar_que_os_dois_enderecos_de_valores_diferentes_sao_diferentes() {
        Endereco endereco = new Endereco("01504000", 819);
        assertThat("falha ao calcular Equals", enderecoRivals.equals(endereco), equalTo(false));
    }

    @Test
    void deve_mostrar_exato_hashcode() {
        assertThat("falha ao calcular HashCode", enderecoRivals.hashCode(), equalTo(-1002358663));
    }

    @Test
    void deve_retornar_string() {
        assertThat("falha ao pegat toString", enderecoRivals.toString(), equalTo("br.com.contmatic.empresa.Endereco@126e945[bairro=Liberdade,cep=01504001,cidade=São Paulo,complemento=apto29,estado=SAOPAULO,numero=819,rua=Rua Vergueiro]"));
    }

}
