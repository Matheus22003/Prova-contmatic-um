package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    void testeAdicionarDataDeNascimento() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        funcionario.setDataNascimento(formato.parse("22/03/2003"));
        assertThat("Erro ao adicionar data de nascimento", formato.format(funcionario.getDataNascimento()), equalTo("22/03/2003"));
    }

    @Test
    void testeAdicionarDataDeNascimentoComErroDeNulo() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        assertThrows(IllegalArgumentException.class, () -> funcionario.setDataNascimento(formato.parse("22/03/2022")));
    }

    @Test
    void testeAdicionarCpf() {
        funcionario.setCpf("42793727806");
        assertThat("Erro ao adicionar CPF", funcionario.getCpf(), equalTo("42793727806"));
    }

    @Test
    void testeAdicionarCpfComErroDeDigitoDoCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf("42793727800"));
    }

    @Test
    void testeAdicionarCpfComErroDeQuantidadeDeDigistosInvalida() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf("4279372234324234237800"));
    }

    @Test
    void testeAdicionarCargo() {
        funcionario.setCargo("Estagiario");
        assertThat("Erro ao adicionar Cargo", funcionario.getCargo(), equalTo("Estagiario"));
    }

    @Test
    void testeAdicionarCargoComErroNumerico() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCargo("23234"));
    }

    @Test
    void testeAdicionarCargoComErroDeTamanho() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCargo("asdasdgsghasjasdjhasjhasdjhasjhasdgjahdgjhasdgajhsdgjasdghjasdghasjdgajjsjssjsjsasdasdasda"));
    }

    @Test
    void testeAdicionarSalario() {
        funcionario.setSalario(2000);
        assertThat("Erro ao adicionar Cargo", funcionario.getSalario(), equalTo(2000.00));
    }

    @Test
    void testeAdicionarSalarioAbaixoDoMinimo() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setSalario(1000));
    }

    @Test
    void testeHashCode() {
        assertThat("Erro ao calcular HashCode", funcionario.hashCode(), equalTo(-617216460));
    }

    @Test
    void testeEqualEntreDoisFuncionariosIguais() {
        Funcionario funcionarioTeste = new Funcionario("42793727806");
        assertThat("Erro ao calcular Equal", funcionario.equals(funcionarioTeste), equalTo(true));
    }

    @Test
    void testeEqualEntreDoisFuncionariosDiferentes() {
        Funcionario funcionarioTeste = new Funcionario("71105099075");
        assertThat("Erro ao calcular Equal", funcionario.equals(funcionarioTeste), equalTo(false));
    }

    @Test
    void testeToString() {
        assertThat("Erro ao exibir toString", funcionario.toString(), equalTo("Funcionario [nome=null, dataNascimento=null, cpf=42793727806, cargo=null, salario=0.0]"));
    }

}
