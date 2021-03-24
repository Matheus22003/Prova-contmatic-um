package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {

	Empresa rivals;

	@BeforeEach
	void setup() {
		rivals = new Empresa("11319526000155");
	}

	@Test
	void testeCriarEmpresaCompleta() {

		rivals.setAreaDeAtuacao("Desenvolvimento");

		rivals.setEndereco(new Endereco("01504001", 819, "apto29"));
		
		assertThat("Endereco retornando errado", rivals.getEndereco(),
				equalTo(new Endereco("01504001", 819, "apto29")));

		assertThat("Erro ao adicionar ou retornar area de atuação", rivals.getAreaDeAtuacao(),
				equalTo("Desenvolvimento"));

	}

	@Test
	void testeCriarEmpresaComErro() {
		assertThrows(RuntimeException.class, () -> {

			new Empresa("1111111100015");

		});
	}

	@Test
	void testeAdicionarFuncionarioNaEmpresa() {
		rivals.addFuncionario(new Funcionario("42793727806"));
		assertThat("Erro ao adicionar Funcionario", rivals.getQuantidadeDeFuncionarios(), equalTo(1));
		assertThat("Erro ao adicionar Funcionario", rivals.getFuncionarios().get(0), equalTo(new Funcionario("42793727806")));
	}
	

}
