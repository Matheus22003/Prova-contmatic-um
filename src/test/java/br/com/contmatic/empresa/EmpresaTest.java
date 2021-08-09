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
    void deve_aceitar_nome_valido() {
        rivals.setNome("Rivals");
        assertThat("Erro ao adicionar ou retornar nome de Empresa", rivals.getNome(),
                equalTo("Rivals"));
    }

    @Test
    void nao_deve_aceitar_um_nome_menor_que_2() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setNome("R"));
    }

    @Test
    void deve_aceitar_nomeFantasia_valido() {
        rivals.setNomeFantasia("Rivals Tournament");
        assertThat("Erro ao adicionar ou retornar Nome Fantasia", rivals.getNomeFantasia(),
                equalTo("Rivals Tournament"));
    }

    @Test
    void nao_deve_aceitar_um_nomeFantasia_menor_que_2() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setNomeFantasia("R"));
    }

    @Test
    void deve_aceitar_cnpj_valido() {
        rivals.setCnpj("73487481000185");
        assertThat("Erro ao adiconar valor em CNPJ", rivals.getCnpj(), equalTo("73487481000185"));
    }

    @Test
    void nao_deve_aceitar_um_cnoj_invalido() {
        rivals.setCnpj("73487481000185");
        assertThrows(CnpjInvalidoException.class, () -> rivals.setCnpj("7348748100018500"));
    }

    @Test
    void deve_aceitar_razaoSocial_valido() {
        rivals.setRazaoSocial("Campeonatos E-Sports");
        assertThat("Erro ao adicionar ou retornar Razão Social", rivals.getRazaoSocial(),
                equalTo("Campeonatos E-Sports"));
    }

    @Test
    void nao_deve_aceitar_um_razaoSocial_menor_que_2() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setRazaoSocial("R"));
    }

    @Test
    void deve_aceitar_areaDeAtuacao_valido() {
        rivals.setAreaDeAtuacao("Desenvolvimento");
        assertThat("Erro ao adicionar ou retornar area de atuação", rivals.getAreaDeAtuacao(),
                equalTo("Desenvolvimento"));
    }

    @Test
    void nao_deve_aceitar_um_razaoSocial_menor_ou_igual_0() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setAreaDeAtuacao(""));
    }

    @Test
    void deve_aceitar_endereco_valido() {
        rivals.setEndereco(new Endereco("01504001", 819));

        assertThat("Endereco retornando errado", rivals.getEndereco(),
                equalTo(new Endereco("01504001", 819)));
    }

    @Test
    void nao_deve_aceitar_um_endereco_com_erro_de_cep() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setEndereco(new Endereco("015040011", 819)));
    }

    @Test
    void deve_aceitar_lista_de_funcionarios_valido() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("42793727806"));
        rivals.setFuncionarios(funcionarios);
        assertThat("Erro ao adicionar Funcionario", rivals.getFuncionarios(), equalTo(funcionarios));
    }

    @Test
    void nao_deve_aceitar_uma_lista_de_funcionarios_com_erro_de_funcionario() {
        List<Funcionario> funcionarios = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> funcionarios.add(new Funcionario("42793727806000")));
        rivals.setFuncionarios(funcionarios);
    }

    @Test
    void nao_deve_aceitar_uma_cnoj_com_cnpj_invalido() {
        assertThrows(RuntimeException.class, () -> new Empresa("1111111100015"));
    }

    @Test
    void deve_mostrar_que_as_duas_empresas_de_cnoj_iguais_sao_as_mesmas() {
        Empresa empresaCloneRivals = new Empresa("11319526000155");
        assertThat("Equals comparando valores errados", rivals.equals(empresaCloneRivals), equalTo(true));
    }

    @Test
    void deve_mostrar_que_as_duas_empresas_de_cnoj_diferentes_sao_diferentes() {
        Empresa empresaCloneRivals = new Empresa("25905179000157");
        assertThat("Equals comparando valores errados", rivals.equals(empresaCloneRivals), equalTo(false));
    }

    @Test
    void deve_mostrar_esse_exato_hashcode() {
        assertThat("Erro ao calcular HashCode", rivals.hashCode(), equalTo(-932838434));
    }

    @Test
    void deve_retornar_string_sem_funcionario() {
        assertThat("Erro ao fazer ToString Sem funcionario", rivals.toString(), equalTo("CNPJ: 11319526000155\n" +
                "Endereço: null\n" +
                "Area de Atuação: null\n" +
                "Ainda não possui nenhum funcionario!"));

    }

    @Test
    void deve_retornar_string_com_funcionario() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(new Funcionario("42793727806"));
        rivals.setFuncionarios(funcionarios);

        assertThat("Erro ao fazer ToString com funcionario", rivals.toString(), equalTo("CNPJ: 11319526000155\n" +
                "Endereço: null\n" +
                "Quantidade de Funcionarios: 1\n" +
                "Area de Atuação: null"));
    }

}
