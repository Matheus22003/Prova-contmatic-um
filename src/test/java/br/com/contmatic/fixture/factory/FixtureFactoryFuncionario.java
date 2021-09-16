package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Funcionario;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;
import org.joda.time.DateTime;

import static br.com.contmatic.fixture.factory.constantes.TiposFixtureFactoryEmpresa.*;
import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryFuncionario implements TemplateLoader {
    Faker faker = new Faker();

    private static final String NOME = "nome";
    private static final String DATA_NASCIMENTO = "dataNascimento";
    private static final String CPF = "cpf";
    private static final String CARGO = "cargo";
    private static final String SALARIO = "salario";

    @Override
    public void load() {
        of(Funcionario.class).addTemplate(VALIDO, new Rule() {
            {
                add(NOME, "Matheus");
                add(DATA_NASCIMENTO, new DateTime(2003, 3, 22, 11, 30));
                add(CPF, "42793727806");
                add(CARGO, "Estagiario");
                add(SALARIO, 2000.00);

            }
        });

        of(Funcionario.class).addTemplate(VALIDO_ALEATORIO, new Rule() {
            {
                add(NOME, faker.pokemon().name());
                add(DATA_NASCIMENTO, new DateTime(2003, 3, 22, 11, 30));
                add(CPF, "42793727806");
                add(CARGO, "Estagiario");
                add(SALARIO, faker.number().randomDouble(2, 2000, 30000));
            }
        });
    }
}
