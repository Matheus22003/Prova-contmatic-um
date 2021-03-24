package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnderecoTest {

	Endereco enderecoRivals;

	@BeforeEach
	void setup() {
		enderecoRivals = new Endereco("01504001", 819, "apto29");
	}

	@Test
	void testeCriacaoEnderecoCompleto() {
		enderecoRivals.setBairro("Liberdade");
		enderecoRivals.setCidade("São Paulo");
		enderecoRivals.setMunicipio("São Paulo");
		enderecoRivals.setRua("Rua Vergueiro");

		assertThat("Erro ao adicionar Bairro", enderecoRivals.getBairro(), equalTo("Liberdade"));
		assertThat("Erro ao adicionar Funcionario", enderecoRivals.getCidade(), equalTo("São Paulo"));
		assertThat("Erro ao adicionar Funcionario", enderecoRivals.getMunicipio(), equalTo("São Paulo"));
		assertThat("Erro ao adicionar Funcionario", enderecoRivals.getRua(), equalTo("Rua Vergueiro"));
	}

	@Test
	void testeCriacaoEnderecoComErro() {
		assertThrows(ExceptionInInitializerError.class, () -> {
			new Endereco("0", 819, "apto29");
		});
	}

	@Test
	void testeCriacaoSemComplemento() {
		Endereco contmatic = new Endereco("01504001", 819, null);
		
		assertThat("Erro a criaçao de Endereco", contmatic.getComplemento(), equalTo(null));
	}

}
