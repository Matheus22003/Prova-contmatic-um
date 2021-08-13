package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Funcionario;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.text.SimpleDateFormat;

import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryFuncionario implements TemplateLoader {
    @Override
    public void load() {
        of(Funcionario.class).addTemplate("valido", new Rule() {
            {
                add("nome", "Matheus");
                add("dataNascimento", randomDate("2021-03-21", "2021-03-23", new SimpleDateFormat("yyyy-MM-dd")));
                add("cpf", "42793727806");
                add("cargo", "Estagiario");
                add("salario", 2000.00);

            }
        });
    }
}
