package br.com.contmatic.telefone;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TelefoneTest {

	Telefone telefone;
	
	@BeforeEach
	void setup() {
		telefone = new Telefone("+55", "011", "987704670");
	}
	
	@Test
	void getDigitoPais() {
		assertThat("Digito inserida incorretamente",telefone.getDigitoPais().toString(),equalTo("+55"));		
	}
	
	@Test
	void getDDD() {
		assertThat("DDD inserido incorretamente",telefone.getDdd().toString(),equalTo("011"));		
	}
	
	@Test
	void getNumeroTelefone() {
		assertThat("Telefone inserido incorretamente",telefone.getTelefone().toString(),equalTo("987704670"));		
	}

}
