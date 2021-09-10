package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;

import java.util.HashSet;

import static br.com.contmatic.fixture.factory.TiposFixtureFactory.*;
import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryEmpresa implements TemplateLoader {

    Faker faker = new Faker();

    private static final String NOME = "nome";
    private static final String NOME_FANTASIA = "nomeFantasia";
    private static final String CNPJ = "cnpj";
    private static final String RAZAO_SOCIAL = "razaoSocial";
    private static final String AREA_DE_ATUACAO = "areaDeAtuacao";
    private static final String ENDERECOS = "enderecos";
    private static final String FUNCIONARIOS = "funcionarios";

    @Override
    public void load() {
        of(Empresa.class).addTemplate(VALIDO, new Rule() {
            {
                add(NOME, random("Rivals"));
                add(NOME_FANTASIA, random("Rivals Tournament"));
                add(CNPJ, random("11319526000155"));
                add(RAZAO_SOCIAL, random("Campeonatos E-Sports"));
                add(AREA_DE_ATUACAO, random("Desenvolvimento"));
                add(ENDERECOS, new HashSet<Endereco>());
                add(FUNCIONARIOS, new HashSet<>());
            }
        });

        of(Empresa.class).addTemplate(VALIDO_ALEATORIO, new Rule() {
            {
                add(CNPJ, cnpj());
                add(NOME, faker.name().name());
                add(NOME_FANTASIA, faker.pokemon().name());
                add(RAZAO_SOCIAL, faker.book().genre());
                add(AREA_DE_ATUACAO, random("Desenvolvimento", "Contabilidade"));
                add(ENDERECOS, one(Endereco.class, VALIDO));
            }
        });

        of(Empresa.class).addTemplate(CNPJ_NULL).inherits(VALIDO, new Rule() {
            {
                add(CNPJ, null);
            }
        });

        of(Empresa.class).addTemplate(CNPJ_INVALID_VALUE).inherits(VALIDO, new Rule() {
            {
                add(CNPJ, "1111111100015");
            }
        });

        of(Empresa.class).addTemplate(NOME_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NOME, "R");
            }
        });

        of(Empresa.class).addTemplate(NOME_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NOME, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });

        of(Empresa.class).addTemplate(NOME_WITH_NUMERICS_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NOME, "as323");
            }
        });

        of(Empresa.class).addTemplate(NOME_FANTASIA_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NOME_FANTASIA, "R");
            }
        });

        of(Empresa.class).addTemplate(NOME_FANTASIA_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NOME_FANTASIA, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });

        of(Empresa.class).addTemplate(RAZAO_SOCIAL_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(RAZAO_SOCIAL, "R");
            }
        });

        of(Empresa.class).addTemplate(RAZAO_SOCIAL_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(RAZAO_SOCIAL, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });

        of(Empresa.class).addTemplate(RAZAO_SOCIAL_WITH_NUMERICS_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(RAZAO_SOCIAL, "asdas23123123");
            }
        });

        of(Empresa.class).addTemplate(AREA_DE_ATUACAO_WITH_BLANK_VALUE).inherits(VALIDO, new Rule() {
            {
                add(AREA_DE_ATUACAO, "");
            }
        });

        of(Empresa.class).addTemplate(AREA_DE_ATUACAO_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(AREA_DE_ATUACAO, "R");
            }
        });

        of(Empresa.class).addTemplate(AREA_DE_ATUACAO_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(AREA_DE_ATUACAO, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });


    }

}
