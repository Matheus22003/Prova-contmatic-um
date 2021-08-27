package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Telefone;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import static br.com.contmatic.empresa.DDD.SAO_PAULO;
import static br.com.contmatic.fixture.factory.TiposFixtureFactory.VALIDO;
import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryTelefone implements TemplateLoader {

    private static final String DIGITO_PAIS = "digitoPais";

    private static final String DDD = "ddd";

    private String NUMERO = "numero";

    @Override
    public void load() {
        of(Telefone.class).addTemplate(VALIDO, new Rule() {
            {
                add(DIGITO_PAIS, "55");
                add(DDD, SAO_PAULO);
                add(NUMERO, "987704670");
            }
        });
    }
}
