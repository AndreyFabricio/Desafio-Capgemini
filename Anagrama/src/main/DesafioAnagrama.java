/**
 * Quest�o 3 do Desafio de Programa��o da Academia Capgemini
 * Esse programa l� uma String e informa 
 * qual � o n�mero de pares de substrings dessa string que s�o anagramas
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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Andrey Fabricio
 * �ltima atualiza��o: 19/02/2022
 *
 */
public class DesafioAnagrama extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Descri��o do desafio:
	 * Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra
	 * podem ser realocadas para formar a outra palavra. Dada uma string qualquer, desenvolva um
	 * algoritmo que encontre o n�mero de pares de substrings que s�o anagramas.
	 * 
	 */
	
	Container container = getContentPane();
	
	// Texto explicativo
	JLabel textoExplicativo = new JLabel(
			"<html>Esse programa encontra os anagramas de uma palavra.<br/>"
			+ "Para come�ar, digite uma palavra e depois clique em \"Encontrar\"</html>"
			);
	
	// Pede ao usuario para digitar a palavra
	JLabel palavra = new JLabel("Digite aqui a palavra para encontrar os anagramas:");
	
	// Input do usuario	
	static JTextField caixaPalavra = new JTextField();
		
	// Bot�o de confirma��o
	JButton btn = new JButton("Encontrar");

	// Texto de erro
	JLabel erro = new JLabel("");
	
	// Caixa de texto
    static JTextArea anagramas = new JTextArea();    
	
    public DesafioAnagrama() {
    	container.setLayout(null);
    	
    	// Tamanho e posi��o dos componentes
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
    	
    	// Adiciona um listener para o bot�o
    	btn.addActionListener(this);
    	
    	// Remove a janela de sele��o ao redor do texto do bot�o
    	btn.setFocusPainted(false);
    	
    	// Cria um listener para a tecla "Enter"
    	caixaPalavra.addActionListener(this); 
    	
    	// Adiciona borda
    	anagramas.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		
		// Se o bot�o for clicado ou o usu�rio apertar a tecla enter
    	if (e.getSource() == btn || e.getSource() == caixaPalavra) {
        	erro.setText(""); // Reseta o erro
        	anagramas.setText(""); // Reseta a caixa de sugest�es
        	criaAnagramas(); // Testa a senha
        	caixaPalavra.setText(""); // Reseta o input do usu�rio
        }
		
	}
    
	public void criaAnagramas() {
		
		String palavra = caixaPalavra.getText().replaceAll("[\\W]+", "");
		String textoTemp = "";
		
		List<String> anagrams = new ArrayList<String>();
		
		for (int i = 0; i < palavra.length(); i++) {
	        for (int j = i + 1; j <= palavra.length(); j++) {
	        	anagrams.add(palavra.substring(i, j));
	        }
	    }
		
		boolean[] pos = new boolean[anagrams.size()];
		boolean pares = false;
		
		for(int k = 0; k < anagrams.size(); k++) {
			
			for (int l = 0; l < anagrams.size(); l++) {
				
				if (k != l && !pos[l] && sameChars(anagrams.get(k), anagrams.get(l))) {
					
					textoTemp += "[" + anagrams.get(k) + "," + anagrams.get(l) + "] ";
					pos[l] = true;
					pos[k] = true;
					pares = true;
					
				}	
				
			}
		}			
		
		if(pares) {
			textoTemp = "A palavra " + palavra + 
			" possui os seguintes pares de anagramas:\r\n" + textoTemp;
		}
		else {
			textoTemp = "A palavra " + palavra + " n�o possui anagramas.";
		}
		
		anagramas.setText(textoTemp);
	}
	
	private boolean sameChars(String firstStr, String secondStr) {
		  char[] first = firstStr.toCharArray();
		  char[] second = secondStr.toCharArray();
		  Arrays.sort(first);
		  Arrays.sort(second);
		  return Arrays.equals(first, second);
		}
	
	public static void main(String[] args) {
		
		DesafioAnagrama frame=new DesafioAnagrama(); // Cria um novo frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        frame.setTitle("Desafio Capgemini - Anagrama"); // Define o titulo
        frame.pack(); // Minimiza os erros de tamanho do layout
        frame.setSize(415, 310); // Define o tamanho do frame
        frame.setLocationRelativeTo(null); // Centraliza o frame
        frame.setResizable(false); // Bloqueia o usu�rio de mudar o tamanho da janela
        frame.setVisible(true); // Torna o frame visivel

	}

}