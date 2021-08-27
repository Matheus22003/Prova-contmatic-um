package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.EstadosBrasil;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import static br.com.contmatic.fixture.factory.TiposFixtureFactory.VALIDO;
import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryEndereco implements TemplateLoader {
    @Override
    public void load() {
        of(Endereco.class).addTemplate(VALIDO, new Rule() {
            {
                add("rua", "Rua Vergueiro");
                add("numero", 819);
                add("complemento", "apto29");
                add("bairro", "Liberdade");
                add("estado", EstadosBrasil.SAOPAULO);
                add("cidade", "São Paulo");
                add("cep", "01504001");
            }
        });
    }
}
