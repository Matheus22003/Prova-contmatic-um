package br.com.contmatic.funcionario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class FuncionarioTest {

	Funcionario matheus;

	@BeforeEach
	void setup() {
		matheus = new Funcionario("Matheus","22/03/2003","42793727806","Estagiario", 2000);
	}

	@Test
	@Timeout(1)
	void getName() {
		String nomeEsperado = "Matheus";
		assertThat("Nome incorreto", matheus.getNome(), equalTo(nomeEsperado));
	}

	@Test
	void getDataNascimento() {
		assertThat("Idade incorreta", matheus.getDataNascimento(), equalTo("22/03/2003"));
	}

	@Test
	void getCpf() {
		System.out.println(matheus.getCpf());
		assertThat("CPF incorreto",matheus.getCpf(),equalTo("42793727806"));
	}
	
	@Test
	@Timeout(1)
	void getCargo() {
		String cargoEsperado = "Estagiario";
		assertThat("Cargo incorreto", matheus.getCargo(), equalTo(cargoEsperado));
	}

	@Test
	@Timeout(1)
	void getSalario() {
		double salarioEsperado = 2000.00;
		assertThat("Salario incorreto", matheus.getSalario(), equalTo(salarioEsperado));
	}

}
