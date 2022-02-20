package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DesafioSenhaTest {

	@Test
	void testTestaSenha() {
		DesafioSenha desafioSenha = new DesafioSenha();
		
		String textoEsperado = "";
		String textoRecebido = "";
		
		textoEsperado = 
				"A senha Ya3 contém menos de 6 caracteres.\r\n" + 
				"Adicione 3 caracteres para a senha ficar mais segura.\r\n" + 
				"A senha Ya3 não possui caracteres especiais.\r\n";
		textoRecebido = desafioSenha.testaSenha("Ya3");		
		assertEquals(textoEsperado, textoRecebido);
		
		textoEsperado = 
				"Parabéns, a sua senha é segura.";
		textoRecebido = desafioSenha.testaSenha("Ya3&ab");		
		assertEquals(textoEsperado, textoRecebido);
	}

}
