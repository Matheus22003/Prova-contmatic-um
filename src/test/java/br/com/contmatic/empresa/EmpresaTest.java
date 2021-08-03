package br.com.contmatic.empresa;

import br.com.contmatic.exception.CnpjInvalidoException;
import br.com.contmatic.exception.CpfInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmpresaTest {

    Empresa rivals;

    @BeforeEach
    void setup() {
        rivals = new Empresa("11319526000155");
    }

    @Test
    void testeAdicionarNome() {
        rivals.setNome("Rivals");
        assertThat("Erro ao adicionar ou retornar nome de Empresa", rivals.getNome(),
                equalTo("Rivals"));
    }

    @Test
    void testeAdicionarNomeComErro() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setNome("R"));
    }

    @Test
    void testeNomeFantasia() {
        rivals.setNomeFantasia("Rivals Tournament");
        assertThat("Erro ao adicionar ou retornar Nome Fantasia", rivals.getNomeFantasia(),
                equalTo("Rivals Tournament"));
    }

    @Test
    void testeNomeFantasiaComErro() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setNomeFantasia("R"));
    }

    @Test
    void testeSetDeCNPJ() {
        rivals.setCnpj("73487481000185");
        assertThat("Erro ao adiconar valor em CNPJ", rivals.getCnpj(), equalTo("73487481000185"));
    }

    @Test
    void testeSetDeCNPJComErro() {
        rivals.setCnpj("73487481000185");
        assertThrows(CnpjInvalidoException.class, () -> rivals.setCnpj("7348748100018500"));
    }

    @Test
    void testeRazaoSocial() {
        rivals.setRazaoSocial("Campeonatos E-Sports");
        assertThat("Erro ao adicionar ou retornar Razão Social", rivals.getRazaoSocial(),
                equalTo("Campeonatos E-Sports"));
    }

    @Test
    void testeRazaoSocialComErro() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setRazaoSocial("R"));
    }

    @Test
    void testeAdicionarAreaDeAtuacao() {
        rivals.setAreaDeAtuacao("Desenvolvimento");
        assertThat("Erro ao adicionar ou retornar area de atuação", rivals.getAreaDeAtuacao(),
                equalTo("Desenvolvimento"));
    }

    @Test
    void testeAdicionarAreaDeAtuacaoComErro() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setAreaDeAtuacao(""));
    }

    @Test
    void testeAdicionarEndereco() {
        rivals.setEndereco(new Endereco("01504001", 819));

        assertThat("Endereco retornando errado", rivals.getEndereco(),
                equalTo(new Endereco("01504001", 819)));
    }

    @Test
    void testeAdicionarEnderecoComErro() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setEndereco(new Endereco("015040011", 819)));
    }

    @Test
    void testeAdicionarListaDeFuncionarioNaEmpresa() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("42793727806"));
        rivals.setFuncionarios(funcionarios);
        assertThat("Erro ao adicionar Funcionario", rivals.getFuncionarios(), equalTo(funcionarios));
    }

    @Test
    void testeAdicionarListaDeFuncionarioNaEmpresaComErroDeFuncionario() {
        List<Funcionario> funcionarios = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> funcionarios.add(new Funcionario("42793727806000")));
        rivals.setFuncionarios(funcionarios);
    }

    @Test
    void testeCriarEmpresaComErro() {
        assertThrows(RuntimeException.class, () -> new Empresa("1111111100015"));
    }

    @Test
    void testeEqualsEntreDuasEmpresasIguais() {
        Empresa empresaCloneRivals = new Empresa("11319526000155");
        assertThat("Equals comparando valores errados", rivals.equals(empresaCloneRivals), equalTo(true));
    }

    @Test
    void testeEqualsEntreDuasEmpresasDiferentes() {
        Empresa empresaCloneRivals = new Empresa("25905179000157");
        assertThat("Equals comparando valores errados", rivals.equals(empresaCloneRivals), equalTo(false));
    }

    @Test
    void testeHashCode() {
        assertThat("Erro ao calcular HashCode", rivals.hashCode(), equalTo(-932838434));
    }

    @Test
    void testeToStringSemFuncionario() {
        assertThat("Erro ao fazer ToString Sem funcionario", rivals.toString(), equalTo("CNPJ: 11319526000155\n" +
                "Endereço: null\n" +
                "Area de Atuação: null\n" +
                "Ainda não possui nenhum funcionario!"));

    }

    @Test
    void testeToStringComFuncionario() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(new Funcionario("42793727806"));
        rivals.setFuncionarios(funcionarios);

        assertThat("Erro ao fazer ToString com funcionario", rivals.toString(), equalTo("CNPJ: 11319526000155\n" +
                "Endereço: null\n" +
                "Quantidade de Funcionarios: 1\n" +
                "Area de Atuação: null"));
    }

    @Test
    void teste() {
        System.out.println("ewrwer");
    }

}
