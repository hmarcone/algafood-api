package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintViolationException;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@SpringBootTest
class AlgafoodApiApplicationTests {

	@SuppressWarnings("deprecation")
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@Test
	public void testarCadastroCozinhaComSucesso() {
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test
	public void testAssertTrue() {
		assertTrue("O parâmetro deve ser true", true);
	}

	@Test
    void meuPrimeiroTeste() {
        assertEquals(2, 1 + 1);
    }	
	
//	@Test(expected = ConstraintViolationException.class)
	@Test
	public void testarCadastroCozinhaSemNome() {
	
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		thrown.expect(NullPointerException.class);
        throw new NullPointerException();
		
	}	
}
