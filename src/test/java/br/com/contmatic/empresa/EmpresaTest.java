package br.com.contmatic.empresa;

import br.com.contmatic.exception.CnpjInvalidoException;
import br.com.contmatic.fixture.factory.TiposFixtureFactory;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.empresa.ValidaAnnotations.returnAnnotationMsgError;
import static br.com.contmatic.fixture.factory.TiposFixtureFactory.VALIDO;
import static br.com.contmatic.fixture.factory.TiposFixtureFactory.VALIDO_ALEATORIO;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmpresaTest {

    Empresa rivals;

    @BeforeAll
    public static void setupTest() {
        loadTemplates("br.com.contmatic.fixture.factory");
    }

    @BeforeEach
    void setup() {
        rivals = from(Empresa.class).gimme(VALIDO);
    }

    @Test
    void deve_aceitar_nome_valido() {
        assertThat("Erro ao adicionar ou retornar nome de Empresa", rivals.getNome(),
                equalTo("Rivals"));
    }

    @Test
    void nao_deve_aceitar_um_nome_menor_que_2() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setNome("R"));
    }

    @Test
    void deve_aceitar_nomeFantasia_valido() {
        assertThat("Erro ao adicionar ou retornar Nome Fantasia", rivals.getNomeFantasia(),
                equalTo("Rivals Tournament"));
    }

    @Test
    void nao_deve_aceitar_um_nomeFantasia_menor_que_2() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setNomeFantasia("R"));
    }

    @Test
    void deve_aceitar_cnpj_valido() {
        assertThat("Erro ao adiconar valor em CNPJ", rivals.getCnpj(), equalTo("11319526000155"));
    }

    @Test
    void nao_deve_aceitar_um_cnoj_invalido() {
        rivals.setCnpj(null);
        returnAnnotationMsgError(rivals, "Funciona");
//        assertThrows(IllegalArgumentException.class, () -> rivals.setCnpj("          "));
    }

    @Test
    void deve_aceitar_razaoSocial_valido() {
        assertThat("Erro ao adicionar ou retornar Razão Social", rivals.getRazaoSocial(),
                equalTo("Campeonatos E-Sports"));
    }

    @Test
    void nao_deve_aceitar_um_razaoSocial_menor_que_2() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setRazaoSocial("R"));
    }

    @Test
    void deve_aceitar_areaDeAtuacao_valido() {
        assertThat("Erro ao adicionar ou retornar area de atuação", rivals.getAreaDeAtuacao(),
                equalTo("Desenvolvimento"));
    }

    @Test
    void nao_deve_aceitar_um_razaoSocial_menor_ou_igual_0() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setAreaDeAtuacao(""));
    }

    @Test
    void deve_aceitar_endereco_valido() {
        assertThat("Endereco retornando errado", rivals.getEndereco(),
                equalTo(from(Endereco.class).gimme(VALIDO)));
    }

    @Test
    void nao_deve_aceitar_um_endereco_com_erro_de_cep() {
        assertThrows(IllegalArgumentException.class, () -> rivals.setEndereco(new Endereco("015040011", 819)));
    }

    @Test
    void deve_aceitar_lista_de_funcionarios_valido() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(from(Endereco.class).gimme(VALIDO));
        rivals.setFuncionarios(funcionarios);
        assertThat("Erro ao adicionar Funcionario", rivals.getFuncionarios(), equalTo(funcionarios));
    }

    @Test
    void nao_deve_aceitar_uma_lista_de_funcionarios_com_erro_de_funcionario() {
        List<Funcionario> funcionarios = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> funcionarios.add(new Funcionario("42793727806000")));
    }

    @Test
    void nao_deve_aceitar_uma_cnoj_com_cnpj_invalido() {
        assertThrows(RuntimeException.class, () -> new Empresa("1111111100015"));
    }

    @Test
    void deve_mostrar_que_as_duas_empresas_de_cnoj_iguais_sao_as_mesmas() {
        Empresa empresaCloneRivals = from(Empresa.class).gimme(VALIDO);
        assertThat("Equals comparando valores errados", rivals.equals(empresaCloneRivals), equalTo(true));
    }

    @Test
    void deve_mostrar_que_as_duas_empresas_de_cnoj_diferentes_sao_diferentes() {
        Empresa empresaCloneRivals = from(Empresa.class).gimme(VALIDO_ALEATORIO);
        assertThat("Equals comparando valores errados", rivals.equals(empresaCloneRivals), equalTo(false));
    }

    @Test
    void deve_mostrar_esse_exato_hashcode() {
        assertThat("Erro ao calcular HashCode", rivals.hashCode(), equalTo(558103052));
    }

    @Test
    void deve_retornar_esse_exato_padrao_string() {
        assertThat("Erro ao fazer ToString com funcionario", rivals.toString(), equalTo("br.com.contmatic.empresa.Empresa@113f5bc[areaDeAtuacao=Desenvolvimento,cnpj=11319526000155,endereco=br.com.contmatic.empresa.Endereco@10f1111[bairro=Liberdade,cep=01504001,cidade=São Paulo,complemento=apto29,estado=SAOPAULO,numero=819,rua=Rua Vergueiro],funcionarios=[],nome=Rivals,nomeFantasia=Rivals Tournament,razaoSocial=Campeonatos E-Sports]"));
    }

}
