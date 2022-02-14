/**
 * Quest�o 1 do Desafio de Programa��o da Academia Capgemini
 * Esse programa mostra na tela uma escada de tamanho n (base e altura)
 * O programa utiliza o caractere * e espa�os para escrever na tela a escada
 * O frontend da aplica��o utiliza Java Swing enquanto que o backend � escrito em Java 
 *  
 */
package main;

import java.util.Scanner;

/**
 * @author Andrey Fabricio
 * Ultima atualiza��o: 14/02/2022
 * 
 */
public class main {
	
	/**
	 * Descri��o do desafio:
	 * Escreva um algoritmo que mostre na tela uma escada de tamanho n 
	 * utilizando o caractere * e espa�os. 
	 * A base e altura da escada devem ser iguais ao valor de n. 
	 * A �ltima linha n�o deve conter nenhum espa�o.
	 * 
	 */
	
	public static void main(String[] args) {
		
		// Variaveis
		int n = 0;
		Scanner scan = new Scanner(System.in);
		
		// Recebe o valor de n do usuario
		
		System.out.print("Digite o tamanho da escada: ");
		n = Integer.parseInt(scan.nextLine());
		
		// Cria��o da escada
		for(int i = 1; i <= n; i++) {
			// Imprime os espa�os
			for(int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			// Imprime os asteriscos e pula a linha
			for(int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}	
	}
}