/**
 * Quest�o 2 do Desafio de Programa��o da Academia Capgemini
 * Esse programa l� uma String e informa qual � o n�mero m�nimo de
 * caracteres que devem ser adicionados para essa String qualquer ser considerada segura
 * O frontend da aplica��o utiliza Java Swing enquanto que o backend � escrito em Java 
 *  
 */
package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Andrey Fabricio
 * �ltima atualiza��o: 14/02/2022
 *
 */
public class DesafioSenha extends JFrame implements ActionListener{

	/**
	 * Descri��o do desafio:
	 * D�bora se inscreveu em uma rede social para se manter em contato com seus amigos. 
	 * A p�gina de cadastro exigia o preenchimento dos campos de nome e senha, por�m 
	 * a senha precisa ser forte. 
	 * O site considera uma senha forte quando ela satisfaz os seguintes crit�rios:
	 * - Possui no m�nimo 6 caracteres.
	 * - Cont�m no m�nimo 1 digito.
	 * - Cont�m no m�nimo 1 letra em min�sculo.
	 * - Cont�m no m�nimo 1 letra em mai�sculo.
	 * - Cont�m no m�nimo 1 caractere especial. Os caracteres especiais s�o: !@#$%^&*()-+
	 * D�bora digitou uma string aleat�ria no campo de senha, por�m ela n�o tem certeza se � uma
	 * senha forte. Para ajudar D�bora, construa um algoritmo que informe qual � o n�mero m�nimo de
	 * caracteres que devem ser adicionados para uma string qualquer ser considerada segura.
	 * 
	 * 
	 * e informa qual � o n�mero m�nimo de
* caracteres que devem ser adicionados para essa String qualquer ser considerada segura
	 */
	
	Container container = getContentPane();
	
	// Texto explicativo
	JLabel textoExplicativo = new JLabel("<html>Esse programa l� uma senha e informa se ela � ou n�o segura.<br/>"
			+ "O programa pode sugerir uma nova senha (mais segura).<br/>"
			+ "Essa nova senha ser� criada com base na senha informada.<br/><br/>"
			+ "As senhas testadas e sugeridas por esse programa<br/> "
			+ "n�o ficar�o salvas em nenhum lugar do computador.<br/>"
			+ "Al�m disso o programa n�o conecta com a internet.<br/><br/>"
			+ "Para come�ar, digite a senha e depois clique em \"Verificar\"</html>");
	
	// Pede ao usuario para digitar a senha
	JLabel digiteSenha = new JLabel("Digite aqui a senha a ser verificada:");
	
	// Input do usuario	
	JTextField senhaUsuario = new JTextField();
	
	// Bot�o de confirma��o
	JButton btn = new JButton("Verificar");

	// Texto de erro
	JLabel erro = new JLabel("");
	
	// Texto de ajuda
	JLabel ajuda = new JLabel("<html>Uma senha segura deve conter:<br/>"+
			"No m�nimo 6 caracteres.<br/>" + 
			"No m�nimo 1 n�mero.<br/>" + 
			"No m�nimo 1 letra em min�sculo.<br/>" + 
			"No m�nimo 1 letra em mai�sculo.<br/>" + 
			"No m�nimo 1 caractere especial.<br/>" +
			"Os caracteres especiais s�o: !@#$%^&*()-+</html>");
	
	// Caixa de texto
    JTextArea sugestoes = new JTextArea();
	
	public DesafioSenha() {
		
		container.setLayout(null);
    	
    	// Tamanho e posi��o dos componentes
    	textoExplicativo.setBounds(20,10,400,150);
    	digiteSenha.setBounds(20,140,250,70);
    	senhaUsuario.setBounds(20, 185, 200, 20);
    	btn.setBounds(220, 185, 85, 19);
    	erro.setBounds(20, 200, 400, 20);
    	sugestoes.setBounds(20, 220, 400, 150);
    	ajuda.setBounds(20, 360, 400, 150);
    	
    	sugestoes.setLineWrap(true);
    	sugestoes.setEditable(false);
    	sugestoes.setVisible(true);    	
    	sugestoes.setFont(new Font("Serif",Font.BOLD,15));// Muda o tamanho e a fonte do texto
    	
    	erro.setForeground(new java.awt.Color(255,0,0)); // Muda para vermelho a cor do erro
    	
    	// Coloca os componentes na janela
    	container.add(textoExplicativo);
    	container.add(digiteSenha);
    	container.add(senhaUsuario);
    	container.add(btn);
    	container.add(erro);
    	container.add(sugestoes);
    	container.add(ajuda);
    	
    	// Adiciona um listener para o bot�o
    	btn.addActionListener(this);
    	
    	// Remove a janela de sele��o ao redor do texto do bot�o
    	btn.setFocusPainted(false);
    	
    	// Cria um listener para a tecla "Enter"
    	senhaUsuario.addActionListener(this); 
    	
    	// Adiciona borda
    	sugestoes.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Se o bot�o for clicado ou o usu�rio apertar a tecla enter
    	if (e.getSource() == btn || e.getSource() == senhaUsuario) {
        	erro.setText(""); // Reseta o erro
        	testaSenha(); // Cria a escada
        	senhaUsuario.setText(""); // Reseta o input do usu�rio
        }
		
	}
	
	private void testaSenha() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		DesafioSenha frame=new DesafioSenha(); // Cria um novo frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
        frame.setTitle("Desafio Capgemini - Senha"); // Define o titulo
        frame.pack(); // Minimiza os erros de tamanho do layout
        frame.setSize(445, 540); // Define o tamanho do frame
        frame.setLocationRelativeTo(null); // Centraliza o frame
        frame.setResizable(false);
        frame.setVisible(true); // Torna o frame visivel
		
	}

}
