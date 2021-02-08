package br.com.contmatic.testeFuncionario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import br.com.contmatic.funcionario.*;

public class FuncionarioEqualsTeste {

	Funcionario matheus;
	Funcionario lucas;

	@BeforeEach
	public void setup() {
		matheus = new Funcionario("Matheus", 17, "Estagiario", 2000);
		lucas = new Funcionario("Lucas", 20, "Desenvolvedor Junior", 5000);
	}

	@Test
	@Timeout(1)
	public void testEquals() {
		boolean resultadoEsperado = false;
		assertThat("O resutado deve ser false", matheus.equals(lucas), equalTo(resultadoEsperado));
	}

	@AfterEach
	public void clear() {
		matheus.clear();
		lucas.clear();
	}

}