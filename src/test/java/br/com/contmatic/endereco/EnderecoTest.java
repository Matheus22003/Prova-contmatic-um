package br.com.contmatic.endereco;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnderecoTest {
	
	Endereco endereco;
	
	@BeforeEach
	void setup() {
		endereco = new Endereco("Rua Vergueiro", 819, "apto29");
	}
	
	@Test
	void getRua() {
		assertThat("Rua inserida incorretamente",endereco.getRua().toString(),equalTo("Rua Vergueiro"));
	}
	
	@Test
	void getNumero() {
		assertThat("Numero inserido incorretamente",endereco.getNumero(),equalTo(819));
	}
	
	@Test
	void getComplemento() {
		assertThat("Rua inserida incorretamente",endereco.getComplemento(),equalTo("apto29"));
	}
}
