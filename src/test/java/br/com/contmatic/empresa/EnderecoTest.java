package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnderecoTest {

    Endereco enderecoRivals;

    @BeforeEach
    void setup() {
        enderecoRivals = new Endereco("01504001", 819);
    }

    @Test
    void testeAdicionarRua() {
        enderecoRivals.setRua("Rua Vergueiro");
        assertThat("falha ao adicionar Rua", enderecoRivals.getRua(), equalTo("Rua Vergueiro"));
    }

    @Test
    void testeAdicionarRuaComErroDeUsoDeNumeral() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setRua("0000000"));
    }

    @Test
    void testeAdicionarRuaComErroDeCaracteresAMenos() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setRua("a"));
    }

    @Test
    void testeAdicionarRuaComErroDeCaracteresAMais() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setRua("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    void TesteAdicionarNumero() {
        enderecoRivals.setNumero(819);
        assertThat("falha ao adicionar Numero", enderecoRivals.getNumero(), equalTo(819));
    }

    @Test
    void testeAdicionarComplemento() {
        enderecoRivals.setComplemento("apto29");
        assertThat("falha ao adicionar complemento", enderecoRivals.getComplemento(), equalTo("apto29"));
    }

    @Test
    void testeAdicionarComplementoComCaracteresAcimaDoMaximo() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setComplemento("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    void testeAdicionarBairro() {
        enderecoRivals.setBairro("Liberdade");
        assertThat("falha ao adicionar bairro", enderecoRivals.getBairro(), equalTo("Liberdade"));
    }

    @Test
    void testeAdicionarBairroComErroDeUsarNumeros() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setBairro("333333"));
    }

    @Test
    void testeAdcionarEstado() {
        enderecoRivals.setEstado(EstadosBrasil.SAOPAULO);
        assertThat("falha ao adicionar Estado", enderecoRivals.getEstado(), equalTo(EstadosBrasil.SAOPAULO));
    }

    @Test
    void testeAdcionarEstadoComErroDeEstarVazio() {
        assertThrows(NullPointerException.class, () -> enderecoRivals.setEstado(null));
    }

    @Test
    void testeAdicionarCidade() {
        enderecoRivals.setCidade("São Paulo");
        assertThat("falha ao adicionar Cidade", enderecoRivals.getCidade(), equalTo("São Paulo"));
    }

    @Test
    void testeAdicionarCidadeComErroDeNumero() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCidade("00000"));
    }

    @Test
    void testeAdicionarCidadeComErroDeQuantidadeMaximaDeCaracteres() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCidade("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    void testeAdicionarCep() {
        enderecoRivals.setCep("01504001");
        assertThat("falha ao adicionar CEP", enderecoRivals.getCep(), equalTo("01504001"));
    }

    @Test
    void testeAdicionarCepComErroDeQuantidadeCaracteresMais() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCep("015040010"));
    }

    @Test
    void testeAdicionarCepComErroDeQuantidadeCaracteresMenos() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCep("01504"));
    }

    @Test
    void testeAdicionarCepComErroDeUtilizacaoDeLetras() {
        assertThrows(IllegalArgumentException.class, () -> enderecoRivals.setCep("aaaa00"));
    }

    @Test
    void testeEqualsComDoisEndercosIguais() {
        Endereco endereco = new Endereco("01504001", 819);
        assertThat("falha ao calcular Equals", enderecoRivals.equals(endereco), equalTo(true));
    }

    @Test
    void testeEqualsComDoisEndercosDiferentes() {
        Endereco endereco = new Endereco("01504000", 819);
        assertThat("falha ao calcular Equals", enderecoRivals.equals(endereco), equalTo(false));
    }

    @Test
    void testeHashCode() {
        assertThat("falha ao calcular HashCode", enderecoRivals.hashCode(), equalTo(-143145273));
    }

    @Test
    void testeToString() {
        assertThat("falha ao pegat toString", enderecoRivals.toString(), equalTo("Endereco{rua='null', numero=819, complemento='null', bairro='null', estado=null, cidade='null', cep='01504001'}"));
    }

}
