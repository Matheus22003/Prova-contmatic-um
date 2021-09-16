package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.EstadosBrasil;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;

import static br.com.contmatic.fixture.factory.constantes.TiposFixtureFactoryEndereco.*;
import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryEndereco implements TemplateLoader {
    Faker faker = new Faker();

    private static final String RUA = "rua";
    private static final String NUMERO = "numero";
    private static final String COMPLEMENTO = "complemento";
    private static final String BAIRRO = "bairro";
    private static final String ESTADO = "estado";
    private static final String CIDADE = "cidade";
    private static final String CEP = "cep";

    @Override
    public void load() {
        of(Endereco.class).addTemplate(VALIDO, new Rule() {
            {
                add(RUA, "Rua Vergueiro");
                add(NUMERO, 819);
                add(COMPLEMENTO, "apto29");
                add(BAIRRO, "Liberdade");
                add(ESTADO, EstadosBrasil.SAOPAULO);
                add(CIDADE, "São Paulo");
                add(CEP, "01504001");
            }
        });

        of(Endereco.class).addTemplate(VALIDO_ALEATORIO, new Rule() {
            {
                add(RUA, faker.address().streetName());
                add(NUMERO, faker.address().streetAddressNumber());
                add(COMPLEMENTO, faker.address().secondaryAddress());
                add(ESTADO, EstadosBrasil.SAOPAULO);
                add(CIDADE, "São Paulo");
                add(CEP, faker.address().zipCode());
            }
        });

        of(Endereco.class).addTemplate(RUA_WITH_BLANK_VALUE).inherits(VALIDO, new Rule() {
            {
                add(RUA, "");
            }
        });

        of(Endereco.class).addTemplate(RUA_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(RUA, "a");
            }
        });

        of(Endereco.class).addTemplate(RUA_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(RUA, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });

        of(Endereco.class).addTemplate(RUA_WITH_NUMERICS_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(RUA, "798789");
            }
        });

        of(Endereco.class).addTemplate(NUMERO_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NUMERO, -2);
            }
        });

        of(Endereco.class).addTemplate(NUMERO_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(NUMERO, 999999999);
            }
        });

        of(Endereco.class).addTemplate(COMPLEMENTO_WITH_BLANK_VALUE).inherits(VALIDO, new Rule() {
            {
                add(COMPLEMENTO, "");
            }
        });

        of(Endereco.class).addTemplate(COMPLEMENTO_WITHOUT_MIN_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(COMPLEMENTO, "1");
            }
        });

        of(Endereco.class).addTemplate(COMPLEMENTO_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(COMPLEMENTO, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });

        of(Endereco.class).addTemplate(BAIRRO_WITH_BLANK_VALUE).inherits(VALIDO, new Rule() {
            {
                add(BAIRRO, "");
            }
        });

        of(Endereco.class).addTemplate(BAIRRO_WITH_NUMERICS_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(BAIRRO, "32134");
            }
        });

        of(Endereco.class).addTemplate(BAIRRO_WITH_MAX_CHARACTERS).inherits(VALIDO, new Rule() {
            {
                add(BAIRRO, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });

        of(Endereco.class).addTemplate(ESTADO_WITH_NULL_VALUE).inherits(VALIDO, new Rule() {
            {
                add(ESTADO, null);
            }
        });


    }
}
