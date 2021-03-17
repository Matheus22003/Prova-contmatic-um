package br.com.contmatic.endereco;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.empresa.Endereco;

class EnderecoTest {
	
	Endereco endereco;
	
	@BeforeEach
	void setup() {
		endereco = new Endereco("Rua Vergueiro", 819, "apto29","Liberdade","São Paulo","São Paulo","01504001");
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
	
	@Test
	void getBairro() {
		assertThat("Bairro inserido incorretamente", endereco.getBairro().toString(), equalTo("Liberdade"));
	}
	
	@Test
	void getMunicipio() {
		assertThat("Municipio inserido incorretamente", endereco.getMunicipio().toString(), equalTo("São Paulo"));
	}
	
	@Test
	void getCidade() {
		assertThat("Cidade inserida incorretamente", endereco.getCidade().toString(), equalTo("São Paulo"));
	}
	
	@Test
	void getCep() {
		assertThat("CEP inserido incorretamente",endereco.getCep().toString(), equalTo("01504001"));
	}
}
