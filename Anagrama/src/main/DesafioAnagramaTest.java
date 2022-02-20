package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DesafioAnagramaTest {

	@Test
	void testCriaAnagramas() {
		DesafioAnagrama desafioAnagrama = new DesafioAnagrama();
		
		String textoEsperado = "";
		String textoRecebido = "";
		
		textoEsperado = 
				"A palavra ovo possui os seguintes pares de anagramas:\r\n" + 
				"[o,o] [ov,vo] ";
		textoRecebido = desafioAnagrama.CriaAnagramas("ovo");		
		assertEquals(textoEsperado, textoRecebido);
		
		textoEsperado = 
				"A palavra ifailuhkqq possui os seguintes pares de anagramas:\r\n" + 
				"[i,i] [ifa,fai] [q,q] ";
		textoRecebido = desafioAnagrama.CriaAnagramas("ifailuhkqq");		
		assertEquals(textoEsperado, textoRecebido);
	}

}
