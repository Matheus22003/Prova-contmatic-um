package br.com.contmatic.testeFuncionario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import br.com.contmatic.funcionario.*;

public class FuncionarioHashTeste {
	Funcionario matheus;

	@BeforeEach
	protected void setup() {
		matheus = new Funcionario("Matheus", 17, "Estagiario", 2000);
	}

	@Test
	@Timeout(1)
	void main() {
		int valorEsperado = 727;
		assertThat("O valor do hashCode está incorreto", matheus.hashCode(), equalTo(valorEsperado));
	}

	@AfterEach
	public void limpeza() {
		matheus.clear();
	}
}
