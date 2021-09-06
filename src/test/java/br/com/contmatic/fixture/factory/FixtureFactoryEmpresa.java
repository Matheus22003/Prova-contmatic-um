package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;

import static br.com.contmatic.fixture.factory.TiposFixtureFactory.*;
import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryEmpresa implements TemplateLoader {

    Faker faker = new Faker();

    private static final String NOME = "nome";
    private static final String NOME_FANTASIA = "nomeFantasia";
    private static final String CNPJ = "cnpj";
    private static final String RAZAO_SOCIAL = "razaoSocial";
    private static final String AREA_DE_ATUACAO = "areaDeAtuacao";
    private static final String ENDERECO = "endereco";

    @Override
    public void load() {
        of(Empresa.class).addTemplate(VALIDO, new Rule() {
            {
                add(NOME, random("Rivals"));
                add(NOME_FANTASIA, random("Rivals Tournament"));
                add(CNPJ, random("11319526000155"));
                add(RAZAO_SOCIAL, random("Campeonatos E-Sports"));
                add(AREA_DE_ATUACAO, random("Desenvolvimento"));
                add(ENDERECO, one(Endereco.class, VALIDO));
            }
        });

        of(Empresa.class).addTemplate(VALIDO_ALEATORIO, new Rule() {
            {
                add("cnpj", cnpj());
                add("nome", faker.name().name());
                add("nomeFantasia", faker.pokemon().name());
                add("razaoSocial", faker.book().genre());
                add("areaDeAtuacao", random("Desenvolvimento", "Contabilidade"));
                add("endereco", one(Endereco.class, VALIDO));
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

        of(Empresa.class).addTemplate(NOME_FANTASIA_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NOME_FANTASIA, "R");
            }
        });

        of(Empresa.class).addTemplate(RAZAO_SOCIAL_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(RAZAO_SOCIAL, "R");
            }
        });

    }

}
