package br.com.contmatic.empresa;

import br.com.contmatic.exception.CnpjInvalidoException;
import br.com.contmatic.fixture.factory.TiposFixtureFactory;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.constantes.EmpresaConstantes.*;
import static br.com.contmatic.empresa.ValidaAnnotations.returnAnnotationMsgError;
import static br.com.contmatic.fixture.factory.TiposFixtureFactory.*;
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
        rivals = from(Empresa.class).gimme(NOME_WITHOUT_MIN_CHARACTERS);
        assertThat("Erro ao adiconar valor em Nome",
                returnAnnotationMsgError(rivals, NOME_LENGTH_MESSAGE),
                equalTo(true));
    }

    @Test
    void deve_aceitar_nomeFantasia_valido() {
        assertThat("Erro ao adicionar ou retornar Nome Fantasia", rivals.getNomeFantasia(),
                equalTo("Rivals Tournament"));
    }

    @Test
    void nao_deve_aceitar_um_nomeFantasia_menor_que_2() {
        rivals = from(Empresa.class).gimme(NOME_FANTASIA_WITHOUT_MIN_CHARACTERS);
        assertThat("Erro ao adiconar valor em NomeFantasia",
                returnAnnotationMsgError(rivals, NOME_FANTASIA_LENGTH_MESSAGE),
                equalTo(true));
    }

    @Test
    void deve_aceitar_cnpj_valido() {
        assertThat("Erro ao adiconar valor em CNPJ", rivals.getCnpj(), equalTo("11319526000155"));
    }

    @Test
    void nao_deve_aceitar_um_cnoj_invalido() {
        rivals = from(Empresa.class).gimme(CNPJ_NULL);
        assertThat("Erro ao adiconar valor em CNPJ",
                returnAnnotationMsgError(rivals, CNPJ_NULL_MESSAGE),
                equalTo(true));
    }

    @Test
    void deve_aceitar_razaoSocial_valido() {
        assertThat("Erro ao adicionar ou retornar Razão Social", rivals.getRazaoSocial(),
                equalTo("Campeonatos E-Sports"));
    }

    @Test
    void nao_deve_aceitar_um_razaoSocial_menor_que_2() {
        rivals = from(Empresa.class).gimme(RAZAO_SOCIAL_WITHOUT_MIN_CHARACTERS);
        assertThat("Erro ao adiconar valor em Razão Social",
                returnAnnotationMsgError(rivals, RAZAO_SOCIAL_LENGTH_MESSAGE),
                equalTo(true));
    }

    @Test
    void deve_aceitar_areaDeAtuacao_valido() {
        assertThat("Erro ao adicionar ou retornar area de atuação", rivals.getAreaDeAtuacao(),
                equalTo("Desenvolvimento"));
    }

    @Test
    void deve_aceitar_endereco_valido() {
        assertThat("Endereco retornando errado", rivals.getEndereco(),
                equalTo(from(Endereco.class).gimme(VALIDO)));
    }

    @Test
    void deve_aceitar_lista_de_funcionarios_valido() {
        List<Funcionario> funcionarios = from(Funcionario.class).gimme(2, VALIDO_ALEATORIO);
        rivals.setFuncionarios(funcionarios);
        assertThat("Erro ao adicionar Funcionario", rivals.getFuncionarios(), equalTo(funcionarios));
    }

    @Test
    void nao_deve_aceitar_uma_cnoj_com_cnpj_invalido() {
        rivals = from(Empresa.class).gimme(CNPJ_INVALID_VALUE);
        assertThat("Erro ao adiconar valor em CNOJ",
                returnAnnotationMsgError(rivals, CNPJ_INVALID_MESSAGE),
                equalTo(true));
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
        assertThat("Erro ao calcular HashCode", rivals.hashCode(), equalTo(-1395910872));
    }

    @Test
    void deve_retornar_esse_exato_padrao_string() {
        assertThat("Erro ao fazer ToString com funcionario", rivals.toString(), equalTo("br.com.contmatic.empresa.Empresa@8c00d9[nome=Rivals,nomeFantasia=Rivals Tournament,cnpj=11319526000155,razaoSocial=Campeonatos E-Sports,areaDeAtuacao=Desenvolvimento,endereco=br.com.contmatic.empresa.Endereco@1a38f07[rua=Rua Vergueiro,numero=819,complemento=apto29,bairro=Liberdade,estado=SAOPAULO,cidade=São Paulo,cep=01504001],funcionarios=[]]"));
    }

}
