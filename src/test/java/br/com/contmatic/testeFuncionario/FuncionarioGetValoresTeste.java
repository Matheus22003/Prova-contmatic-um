package br.com.contmatic.testeFuncionario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import br.com.contmatic.funcionario.*;

@TestMethodOrder(OrderAnnotation.class)
public class FuncionarioGetValoresTeste {
	Funcionario matheus;

	@BeforeEach
	void setup() {
		matheus = new Funcionario("Matheus", 17, "Estagiario", 2000);
	}

	@Test
	@Timeout(1)
	public void getName() {
		String nomeEsperado = "Matheus";
		assertThat("Nome incorreto", matheus.getNome(), equalTo(nomeEsperado));

	}

	@Test
	@Timeout(1)
	public void getIdade() {
		int idadeEsperada = 17;
		assertThat("Idade incorreta", matheus.getIdade(), equalTo(idadeEsperada));
	}

	@Test
	@Timeout(1)
	public void getCargo() {
		String cargoEsperado = "Estagiario";
		assertThat("Cargo incorreto", matheus.getCargo(), equalTo(cargoEsperado));
	}

	@Test
	@Timeout(1)
	public void getSalario() {
		double salarioEsperado = 2000.00;
		assertThat("Salario incorreto", matheus.getSalario(), equalTo(salarioEsperado));
	}
}
