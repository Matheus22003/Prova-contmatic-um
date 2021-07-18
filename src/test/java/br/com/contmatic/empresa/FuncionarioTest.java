package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FuncionarioTest {
    Funcionario funcionario;

    @BeforeEach
    void setup() {
        funcionario = new Funcionario("42793727806");
    }

    @Test
    void testeAdicionarNome() {
        funcionario.setNome("Matheus");
        assertThat("Erro ao adicionar nome", funcionario.getNome(), equalTo("Matheus"));
    }

    @Test
    void testeAdicionarNomeComErroDeUtilizacaoDeNumeros() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setNome("123"));
    }

    @Test
    void testeAdicionarNomeComErroDeQuantidadeMaximaCaracteres() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setNome("asdasdgsghasjasdjhasjhasdjhasjhasdgjahdgjhasdgajhsdgjasdghjasdghasjdgajjsjssjsjs"));
    }

    @Test
    void testeAdicionarDataDeNascimento() {
        funcionario.setDataNascimento();
        assertThat("Erro ao adicionar nome", funcionario.getNome(), equalTo("Matheus"));
    }

}
