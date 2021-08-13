package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.Funcionario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryFuncionario implements TemplateLoader {
    @Override
    public void load() {
        of(Funcionario.class).addTemplate("valido", new Rule() {
            {
                add("nome", "");
                add("dataNascimento", "");
                add("dataNascimento", "");

            }
        });
    }
}
