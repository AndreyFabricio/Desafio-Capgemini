/**
 * Quest�o 1 do Desafio de Programa��o da Academia Capgemini
 * Esse programa mostra na tela uma escada de tamanho n (base e altura)
 * O programa utiliza o caractere * e espa�os para escrever na tela a escada
 * O frontend da aplica��o utiliza Java Swing enquanto que o backend � escrito em Java 
 *  
 */
package main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Andrey Fabricio
 * Ultima atualiza��o: 14/02/2022
 * 
 */
public class DesafioEscada extends JFrame implements ActionListener {
	
	/**
	 * Descri��o do desafio:
	 * Escreva um algoritmo que mostre na tela uma escada de tamanho n 
	 * utilizando o caractere * e espa�os. 
	 * A base e altura da escada devem ser iguais ao valor de n. 
	 * A �ltima linha n�o deve conter nenhum espa�o.
	 * 
	 */
	
	 // Variaveis
	static String n = "";
	
	Container container = getContentPane();
	
	// Texto explicativo
	JLabel textoExplicativo = new JLabel("<html>Esse programa cria uma escada usando * e espa�os<br/>"
			+ "Para come�ar, digite o tamanho da escada e depois clique em \"Criar\"</html>");
	
	// Pede ao usuario para digitar o tamanho desejado da escada
	JLabel textoEscada = new JLabel("Digite o tamanho da escada:");
		
	// Input do usuario	
	JTextField textoUsuario = new JTextField();	
	
	// Bot�o de confirma��o
	JButton btn = new JButton("Criar");
	
	// Texto de erro
	 JLabel erro = new JLabel("");	
	
	// Area aonde ficar� a escada
    static JTextArea escada = new JTextArea();
    
    public DesafioEscada() {    	
    	
    	container.setLayout(null);
    	
    	// Tamanho e posi��o dos componentes
    	textoExplicativo.setBounds(20,10,400,30);
    	textoEscada.setBounds(20,30,250,70);
    	textoUsuario.setBounds(185, 55, 20, 20);
    	btn.setBounds(205, 55, 65, 19);
    	erro.setBounds(20, 80, 50, 20);
    	escada.setBounds(20,100,400,435);
    	
    	escada.setLineWrap(true); // Permite pular linhas na area do texto
    	escada.setVisible(false); // A area s� fica visivel ap�s a confirma��o do usuario
    	escada.setEditable(false); // Permite ao usuario copiar a escada mas n�o editar
    	
    	erro.setForeground(new java.awt.Color(255,0,0)); // Muda para vermelho a cor do texto
    	
    	// Coloca os componentes na janela
    	container.add(textoExplicativo);
    	container.add(textoEscada);
    	container.add(textoUsuario);
    	container.add(btn);
    	container.add(erro);
    	container.add(escada);
    	
    	// Adiciona um listener para o bot�o
    	btn.addActionListener(this);
    	
    	// Remove a janela de sele��o ao redor do texto do bot�o
    	btn.setFocusPainted(false);
    	
    	// Cria um listener para a tecla "Enter"
    	textoUsuario.addActionListener(this); 
    	
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		
		// Se o bot�o for clicado ou o usu�rio apertar a tecla enter
    	if (e.getSource() == btn || e.getSource() == textoUsuario) {
        	erro.setText(""); // Reseta o erro
        	escada.setVisible(false); // Esconde a escada atual
        	criaEscada(); // Cria a escada
        	textoUsuario.setText(""); // Reseta o input do usu�rio
        }
		
	}
    
    private static void criaEscada() {
		
    	String textoEscada = "";
    	
    	/*
    	
		// Cria��o da escada
		for(int i = 1; i <= n; i++) {
			// Cria os espa�os
			for(int j = 1; j <= n - i; j++) {						
				textoEscada += " ";
			}
			// Cria os asteriscos
			for(int k = 1; k <= i; k++) {
				textoEscada += "*";
			}
			// Pula a linha
			textoEscada += "\n";
		}
		
		*/
		
		escada.setText(textoEscada); // Coloca a escada ma janela
		
	}
	
	public static void main(String[] args) {	
				
		DesafioEscada frame=new DesafioEscada(); // Cria um novo frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        frame.setTitle("Desafio Capgemini - Escada"); // Define o titulo
        frame.pack(); // Minimiza os erros de tamanho do layout
        frame.setSize(460, 600); // Define o tamanho do frame
        frame.setLocationRelativeTo(null); // Centraliza o frame
        frame.setVisible(true); // Torna o frame visivel
		
	}
}