package br.com.contmatic.fixture.factory;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.Funcionario;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import static br.com.six2six.fixturefactory.Fixture.of;

public class FixtureFactoryEmpresa implements TemplateLoader {

    @Override
    public void load() {
        of(Empresa.class).addTemplate("valido", new Rule() {
            {
                add("nome", random("Rivals"));
                add("nomeFantasia", random("Rivals Tournament"));
                add("cnpj", random("11319526000155"));
                add("razaoSocial", random("Campeonatos E-Sports"));
                add("areaDeAtuacao", random("Desenvolvimento"));
                add("endereco", fixture(Endereco.class, "valido"));
            }
        });

        of(Empresa.class).addTemplate("validoAleatorio", new Rule() {
            {
                add("nome", random("Rivals", "Contmatic"));
                add("nomeFantasia", random("Rivals Tournament", "Contmatic Fenix"));
                add("cnpj", random("49007072000150", "02031873000197"));
                add("razaoSocial", random("Campeonatos E-Sports", "Softmatic Sistemas Automaticos de Informatica Ltda"));
                add("areaDeAtuacao", random("Desenvolvimento", "Contabilidade"));
                add("endereco", fixture(Endereco.class, "valido"));
            }
        });


    }

}
