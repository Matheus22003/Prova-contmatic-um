package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class EmpresaTest {

	Empresa rivals;
	
	@BeforeEach
	void setup() {
		rivals = new Empresa("11319526000155");
	}

	@Test
	void criarEmpresaCompleta() {
		
		rivals.setAreaDeAtuacao("Desenvolvimento");
		
		rivals.setEndereco(new Endereco("01504001", 819, "apto29"));
		
		assertThat("Endereco retornando errado", rivals.getEndereco(), equalTo(new Endereco("01504001", 819, "apto29")));
		
		assertThat("teste",rivals.getAreaDeAtuacao(),equalTo("Desenvolvimento"));
		
	}
	
	@Test
	void criarEmpresa() {
		
	}

}
