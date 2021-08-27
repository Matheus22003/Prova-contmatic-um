package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Funcionario;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;

import static br.com.contmatic.fixture.factory.TiposFixtureFactory.*;
import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryFuncionario implements TemplateLoader {
    @Override
    public void load() {
        of(Funcionario.class).addTemplate(VALIDO, new Rule() {
            {
                add("nome", "Matheus");
                add("dataNascimento", new DateTime(2003, 3, 22, 11, 30));
                add("cpf", "42793727806");
                add("cargo", "Estagiario");
                add("salario", 2000.00);

            }
        });
    }
}
