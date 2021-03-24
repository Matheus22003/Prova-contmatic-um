package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FuncionarioTest {
	Funcionario funcionario;

	@BeforeEach
	void setup() {
		funcionario = new Funcionario("42793727806");
	}

	@Test
	void testeCriacaoCompletaFuncionario() {
		funcionario.setCargo("Estagiario");
		funcionario.setDataNascimento("22/03/2003");
		funcionario.setNome("Matheus");
		funcionario.setSalario(2000);

		assertThat("CPF inserido incorretamente", funcionario.getCpf().toString(), equalTo("42793727806"));
		assertThat("Cargo inserido incorretamente", funcionario.getCargo(),equalTo("Estagiario"));
		assertThat("DataNascimento inserido de maneira incorreta", funcionario.getDataNascimento(),equalTo("22/03/2003"));
		assertThat("Nome inserido incorretamente",funcionario.getNome(),equalTo("Matheus"));
		assertThat("Salario inserido incorretamente", funcionario.getSalario(),equalTo(2000.0));
	}
	
	@Test
	void testeCriacaoComErroFuncionario() {
		assertThrows(Exception.class, () -> {
			new Funcionario("427.937.278-06");
		});
	}
	

}
