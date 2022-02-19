/**
 * Questão 3 do Desafio de Programação da Academia Capgemini
 * Esse programa lê uma String e informa 
 * qual é o número de pares de substrings dessa string que são anagramas
 *  
 */
package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Andrey Fabricio
 * Última atualização: 19/02/2022
 *
 */
public class DesafioAnagrama extends JFrame implements ActionListener{

	/** Descrição do desafio:
	 * Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra
	 * podem ser realocadas para formar a outra palavra. Dada uma string qualquer, desenvolva um
	 * algoritmo que encontre o número de pares de substrings que são anagramas.
	 * 
	 */
	
	Container container = getContentPane();
	
	// Texto explicativo
	JLabel textoExplicativo = new JLabel(
			"<html>Esse programa encontra os anagramas de uma palavra.<br/>"
			+ "Para começar, digite uma palavra e depois clique em \"Encontrar\"</html>"
			);
	
	// Pede ao usuario para digitar a palavra
	JLabel palavra = new JLabel("Digite aqui a palavra para encontrar os anagramas:");
	
	// Input do usuario	
	static JTextField caixaPalavra = new JTextField();
		
	// Botão de confirmação
	JButton btn = new JButton("Encontrar");

	// Texto de erro
	JLabel erro = new JLabel("");
	
	// Caixa de texto
    static JTextArea anagramas = new JTextArea();    
	
    public DesafioAnagrama() {
    	container.setLayout(null);
    	
    	// Tamanho e posição dos componentes
    	textoExplicativo.setBounds(20,10,400,40);
    	palavra.setBounds(20,30,400,70);
    	caixaPalavra.setBounds(20, 75, 200, 20);
    	btn.setBounds(220, 75, 90, 19);
    	erro.setBounds(20, 93, 360, 20);
    	anagramas.setBounds(20, 110, 368, 150);
    	
    	// Configura a caixa de texto
    	anagramas.setLineWrap(true);
    	anagramas.setEditable(false);
    	anagramas.setVisible(true);    	
    	anagramas.setFont(new Font("Serif",Font.PLAIN,15));// Muda o tamanho e a fonte do texto
    	
    	erro.setForeground(new java.awt.Color(255,0,0)); // Muda para vermelho a cor do erro
    	
    	// Coloca os componentes na janela
    	container.add(textoExplicativo);
    	container.add(palavra);
    	container.add(caixaPalavra);
    	container.add(btn);
    	container.add(erro);
    	container.add(anagramas);
    	
    	// Adiciona um listener para o botão
    	btn.addActionListener(this);
    	
    	// Remove a janela de seleção ao redor do texto do botão
    	btn.setFocusPainted(false);
    	
    	// Cria um listener para a tecla "Enter"
    	caixaPalavra.addActionListener(this); 
    	
    	// Adiciona borda
    	anagramas.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		
		// Se o botão for clicado ou o usuário apertar a tecla enter
    	if (e.getSource() == btn || e.getSource() == caixaPalavra) {
        	erro.setText(""); // Reseta o erro
        	anagramas.setText(""); // Reseta a caixa de sugestões
        	criaAnagramas(); // Testa a senha
        	caixaPalavra.setText(""); // Reseta o input do usuário
        }
		
	}
    
	public void criaAnagramas() {
		
		String palavraOriginal = caixaPalavra.getText().replaceAll("[\\W]+", "");
		
		for(int i = 0; i < palavraOriginal.length(); i++) {
			
			String letras = palavraOriginal.charAt(i) + "";	
			
			for(int j = 0; j < palavraOriginal.length(); j++) {
				
				if(j != i) {
					letras += palavraOriginal.charAt(j) + "";
				}

				permutation("", letras);
			}
		}
		
		List<String> anagrms = Arrays.asList(anagramas.getText().split("[\\s]+"));
		
		List<String> anagrams = new ArrayList<String>();
		
		for(String combinacao : anagrms) {
			
			if(!anagrams.contains(combinacao)) {
				anagrams.add(combinacao);
			}
			
		}
		
		palavraOriginal = "";
		
		for(String anagram : anagrams) {
			palavraOriginal += anagram + " ";
		}
		
		anagramas.setText(palavraOriginal);
		
	}
	
	public static void permutation(String prefixo, String palavra) {
	    int tamanhoPalavra = palavra.length();
	    if (tamanhoPalavra == 0) {
	    	anagramas.setText(anagramas.getText() + prefixo + " ");
	    }
	    else {
	        for (int i = 0; i < tamanhoPalavra; i++)
	            permutation(prefixo + palavra.charAt(i), 
	            		palavra.substring(0, i) + palavra.substring(i+1, tamanhoPalavra));
	    }
	}
	
	public static void main(String[] args) {
		
		DesafioAnagrama frame=new DesafioAnagrama(); // Cria um novo frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        frame.setTitle("Desafio Capgemini - Anagrama"); // Define o titulo
        frame.pack(); // Minimiza os erros de tamanho do layout
        frame.setSize(415, 310); // Define o tamanho do frame
        frame.setLocationRelativeTo(null); // Centraliza o frame
        frame.setResizable(false); // Bloqueia o usuário de mudar o tamanho da janela
        frame.setVisible(true); // Torna o frame visivel

	}

}