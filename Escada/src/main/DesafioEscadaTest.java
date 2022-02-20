package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DesafioEscadaTest {

	@Test
	void testGeraEscada() {
		
		DesafioEscada desafioEscada = new DesafioEscada();
		
		String textoEsperado = 
				"        *\n"
				+ "       **\n"
				+ "      ***\n"
				+ "     ****\n"
				+ "    *****\n"
				+ "   ******\n"
				+ "  *******\n"
				+ " ********\n"
				+ "*********";
		String textoRecebido = desafioEscada.GeraEscada(9);
		
		assertEquals(textoEsperado, textoRecebido);
		
	}

}
