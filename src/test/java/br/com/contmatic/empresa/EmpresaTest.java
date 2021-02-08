package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import br.com.contmatic.funcionario.Funcionario;

class EmpresaTest {

	Empresa contmatic;

	Funcionario matheus;

	@BeforeEach
	void setup() {
		contmatic = new Empresa("60872504000123", "Rua Vergueiro, 819", "Contabilidade");
		matheus = new Funcionario("Matheus", 17, "Estagiario", 2000);
	}
	
	@Test
	void addFuncionario() {
		ArrayList<Funcionario> valorEsperado = new ArrayList<Funcionario>();
		valorEsperado.add(matheus);
		contmatic.addFuncionario(matheus);
		assertThat("Funcionarios estão sendo adicionados de maneira incorreta", contmatic.getFuncionarios(),
				equalTo(valorEsperado));
	}

	@Test
	@Timeout(1)
	void getCnpj() {
		String valorEsperado = "60872504000123";
		assertThat("Valor do CNPJ incorreto", contmatic.getCnpj(), equalTo(valorEsperado));
	}

	@Test
	@Timeout(1)
	void getEndereco() {
		String valorEsperado = "Rua Vergueiro, 819";
		assertThat("Valor do endereço incorreto", contmatic.getEndereco(), equalTo(valorEsperado));
	}

	@Test
	@Timeout(1)
	void getQuantidadeDeFuncionarios() {
		int valorEsperado = 0;
		assertThat("Valor de funcionarios incorreto", contmatic.getQuantidadeDeFuncionarios(), equalTo(valorEsperado));
	}

	@Test
	@Timeout(1)
	void getFuncionarios() {
		ArrayList<Funcionario> valorEsperado = new ArrayList<Funcionario>();
		valorEsperado.clear();
		assertThat("Valores de Funcionarios está incorreto", contmatic.getFuncionarios(), equalTo(valorEsperado));
	}

	@Test
	@Timeout(1)
	void getAreaDeAtuacao() {
		String valorEsperado = "Contabilidade";
		assertThat("Valor da área de atuação incorreta", contmatic.getAreaDeAtuacao(), equalTo(valorEsperado));
	}

	@Test
	void TesteValorHash() {
		int valorEsperado = -8687519;		
		assertThat("Valor do hashcode incorreto", contmatic.hashCode(), equalTo(valorEsperado));
	}

}
