/**
 * Quest�o 1 do Desafio de Programa��o da Academia Capgemini
 * Esse programa mostra na tela uma escada de tamanho n (base e altura)
 * O programa utiliza o caractere * e espa�os para escrever na tela a escada
 * O frontend da aplica��o utiliza Java Swing enquanto que o backend � escrito em Java 
 *  
 */
package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Andrey Fabricio
 * Ultima atualiza��o: 19/02/2022
 * 
 */
public class DesafioEscada extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Descri��o do desafio:
	 * Escreva um algoritmo que mostre na tela uma escada de tamanho n 
	 * utilizando o caractere * e espa�os. 
	 * A base e altura da escada devem ser iguais ao valor de n. 
	 * A �ltima linha n�o deve conter nenhum espa�o.
	 * 
	 */
	
	Container container = getContentPane();
	
	// Texto explicativo
	JLabel textoExplicativo = new JLabel("<html>Esse programa cria uma escada usando * e espa�os<br/>"
			+ "Para come�ar, digite o tamanho da escada e depois clique em \"Criar\"</html>");
	
	// Pede ao usuario para digitar o tamanho desejado da escada
	JLabel textoEscada = new JLabel("Digite o tamanho da escada:");
		
	// Input do usuario	
	static JTextField textoUsuario = new JTextField();	
	
	// Bot�o de confirma��o
	JButton btn = new JButton("Criar");
	
	// Texto de erro
	static JLabel erro = new JLabel("");	
	
	// Area aonde ficar� a escada
    static JTextArea escada = new JTextArea("");
    
    // Barras de rolagem
    JScrollPane jsp = new JScrollPane(escada);
    
    public DesafioEscada() {    	
    	
    	container.setLayout(null);
    	
    	// Tamanho e posi��o dos componentes
    	textoExplicativo.setBounds(20,10,400,30);
    	textoEscada.setBounds(20,30,250,70);
    	textoUsuario.setBounds(185, 55, 40, 20);
    	btn.setBounds(225, 55, 65, 19);
    	erro.setBounds(20, 80, 400, 20);
    	jsp.setBounds(20,100,400,450);
    	
    	// Muda o tamanho e a fonte da escada
    	escada.setFont(new Font("Monospaced",Font.BOLD,15));
    	 
    	// Muda para vermelho a cor do erro
    	erro.setForeground(new java.awt.Color(255,0,0));
    	
    	// Coloca os componentes na janela
    	container.add(textoExplicativo);
    	container.add(textoEscada);
    	container.add(textoUsuario);
    	container.add(btn);
    	container.add(erro);
    	container.add(jsp);
    	
    	jsp.setPreferredSize(new Dimension(400, 450));
    	
    	// Adiciona borda a caixa do texto
    	jsp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    	
    	// Mostra a barra de rolagem vertical quando necess�rio
    	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	
    	// Mostra a barra de rolagem horizontal quando necess�rio
    	jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
    	
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
        	escada.setText(criaEscada()); // Cria a escada
        	textoUsuario.setText(""); // Reseta o input do usu�rio
        }
		
	}
    
    public String criaEscada() {
		
    	String textoEscada = "";
    	int tamanho = 0;
    	boolean valido = true;
    	
    	try {
    		// Tenta transformar a entrada do usu�rio em um n�mero inteiro
    		tamanho = Integer.parseInt(textoUsuario.getText()); 
        } catch(NumberFormatException nfe) {  
        	// Se a entrada for inv�lida passa uma mensagem de erro para o usu�rio  
        	// e torna o a entrada inv�lida
        	erro.setText("O valor \"" + textoUsuario.getText() +"\" n�o � v�lido");
        	valido = false; 
        }
    	
    	// Se o tamanho for 0 ou negativo, mostra um erro
        if (tamanho < 1) {
        	erro.setText("O valor \"" + textoUsuario.getText() +"\" "
        			+ " n�o � um valor positivo v�lido");
        	valido = false; // A entrada se torna ent�o inv�lida
        }
    	
        if(valido) { // Se a entrada do usu�rio for v�lida
        	textoEscada += GeraEscada(tamanho);
        }
		return textoEscada;
		
	}
	
	public String GeraEscada(int tamanho) {
		// Cria��o da escada
		String texto = "";
		for(int i = 1; i <= tamanho; i++) {    			
			for(int j = 1; j <= tamanho - i; j++)// Cria os espa�os
				texto += " ";
			for(int k = 1; k <= i; k++) // Cria os asteriscos
				texto += "*";
			if(i != tamanho)// Pula a linha
				texto += "\n";
		}
		return texto;
	}

	public static void main(String[] args) {	
				
		DesafioEscada frame=new DesafioEscada(); // Cria um novo frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        frame.setTitle("Desafio Capgemini - Escada"); // Define o titulo
        frame.pack(); // Minimiza os erros de tamanho do layout
        frame.setSize(445, 600); // Define o tamanho do frame
        frame.setLocationRelativeTo(null); // Centraliza o frame
        frame.setResizable(false); // Impede o us�rio de mudar o tamanho da janela
        frame.setVisible(true); // Torna o frame visivel
		
	}
}