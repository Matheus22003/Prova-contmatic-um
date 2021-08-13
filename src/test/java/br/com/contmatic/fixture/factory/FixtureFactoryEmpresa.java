package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryEmpresa implements TemplateLoader {

    @Override
    public void load() {
        of(Empresa.class).addTemplate("valido", new Rule() {
            {
                add("nome", random("Rivals"));
                add("nomeFantasia", random( "Rivals Tournament"));
                add("cnpj", random("11319526000155"));
                add("razaoSocial", random("Campeonatos E-Sports"));
                add("areaDeAtuacao", random("Desenvolvimento"));
                add("endereco", fixture(Endereco.class, "valido"));
            }
        });



    }

}
