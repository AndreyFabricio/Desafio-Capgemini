/**
 * Questão 1 do Desafio de Programação da Academia Capgemini
 * Esse programa mostra na tela uma escada de tamanho n (base e altura)
 * O programa utiliza o caractere * e espaços para escrever na tela a escada
 * O frontend da aplicação utiliza Java Swing enquanto que o backend é escrito em Java 
 *  
 */
package main;

import java.util.Scanner;

/**
 * @author Andrey Fabricio
 * Ultima atualização: 14/02/2022
 * 
 */
public class main {
	
	/**
	 * Descrição do desafio:
	 * Escreva um algoritmo que mostre na tela uma escada de tamanho n 
	 * utilizando o caractere * e espaços. 
	 * A base e altura da escada devem ser iguais ao valor de n. 
	 * A última linha não deve conter nenhum espaço.
	 * 
	 */
	
	public static void main(String[] args) {
		
		// Variaveis
		int n = 0;
		Scanner scan = new Scanner(System.in);
		
		// Recebe o valor de n do usuario
		
		System.out.print("Digite o tamanho da escada: ");
		n = Integer.parseInt(scan.nextLine());
		
		// Criação da escada
		for(int i = 1; i <= n; i++) {
			// Imprime os espaços
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