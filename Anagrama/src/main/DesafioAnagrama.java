/**
 * Quest�o 3 do Desafio de Programa��o da Academia Capgemini
 * Esse programa l� uma String e informa 
 * qual � o n�mero de pares de substrings dessa string que s�o anagramas entre si
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
			"<html>Esse programa encontra os anagramas de uma palavra.<br/>" +
			"Para come�ar, digite uma palavra e depois clique em \"Encontrar\"</html>"
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
    	
    	// Muda o tamanho e a fonte do texto
    	anagramas.setFont(new Font("Serif",Font.PLAIN,15));
    	 
    	// Muda para vermelho a cor do erro
    	erro.setForeground(new java.awt.Color(255,0,0));
    	
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
		
		// Executa somente se existe algum texto na caixa de texto
		if(!caixaPalavra.getText().equals("")) {

			// Pega o que o usu�rio digitou na caixa de texto
			String palavra = caixaPalavra.getText().replaceAll("[\\W]+", "");
			
			// Armazena o texto que ser� exibido para o usu�rio
			String textoTemp = "";
			
			// Armazena os anagramas
			List<String> anagrams = new ArrayList<String>();
			
			// Percorre a palavra duas vezes para criar as substrings da palavra
			// Depois armazena as substrings na lista anagrams
			for (int i = 0; i < palavra.length(); i++) {
		        for (int j = i + 1; j <= palavra.length(); j++) {
		        	anagrams.add(palavra.substring(i, j));
		        }
		    }
			
			// Armazena booleanos para checar se uma substring j� foi utilizada
			boolean[] pos = new boolean[anagrams.size()];
			// "pares" se torna verdadeiro se houver ao menos um par de anagramas
			boolean pares = false;
			
			// Percorre a lista de substrings para encontrar pares de anagramas
			for(int k = 0; k < anagrams.size(); k++) {				
				for (int l = 0; l < anagrams.size(); l++) {
					// Se o par de substrings analisado n�o for exatamente a mesma substring
					// E se o par de substrings possui as mesmas letras ele ent�o � um anagrama
					if (k != l && !pos[l] 
							&& testaAnagrama(anagrams.get(k), anagrams.get(l))) {
						// Adiciona o par de anagramas ao texto que ser� exibido ao usu�rio
						textoTemp += "[" + anagrams.get(k) + "," + anagrams.get(l) + "] ";
						// Coloca as substrings como utilizadas
						pos[l] = true;
						pos[k] = true;
						// Informa que existe ao menos um par de anagramas
						pares = true;
						
					}	
					
				}
			}			
			
			if(pares) { // Se existe ao menos um par de anagramas
				// Finaliza o texto para o usu�rio
				textoTemp = "A palavra " + palavra + 
				" possui os seguintes pares de anagramas:\r\n" + textoTemp;
			}
			else {
				// Informa ao usu�rio que n�o existem anagramas
				textoTemp = "A palavra " + palavra + " n�o possui anagramas.";
			}
			
			// Exibe para o usu�rio a mensagem final da execu��o atual
			anagramas.setText(textoTemp);
		}
		else {
			// Informa ao usu�rio que ele n�o digitou na caixa de texto
			erro.setText("Digite uma palavra");
		}
	}
	
	private boolean testaAnagrama(String primeiraSubs, String segundaSubs) {
		// Testa se as substrings possuem as mesma letras (se s�o anagramas)
		char[] primeira = primeiraSubs.toCharArray();
		char[] segunda = segundaSubs.toCharArray();
		Arrays.sort(primeira); // Organiza a primeira substring em ordem alfabetica
		Arrays.sort(segunda);// Organiza a segunda substring em ordem alfabetica
		// O m�todo retorna verdadeiro se as substrings forem iguais
		return Arrays.equals(primeira, segunda); 
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