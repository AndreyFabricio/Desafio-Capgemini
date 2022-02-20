# Desafio-Capgemini
Desafio de programação para a terceira etapa do processo de seleção para a Academia Capgemini 2022.<br />
O desafio consiste de três questões explicadas a seguir. 

A primeira questão pede para que seja criado um programa que mostra na tela uma escada de tamanho n.<br />
Essa escada utiliza o caractere * e espaços para ser construída.<br />
A base e altura da escada devem ser iguais ao valor de n.<br />
A última linha da escada não deve conter nenhum espaço.<br />

A segunda questão pede que seja lida uma String informada pelo usuário que representa uma senha.<br />
O programa informa então qual é o número mínimo de caracteres que devem ser adicionados para essa String qualquer ser considerada uma senha segura.<br />
Uma senha segura deve conter:<br />
No mínimo 6 caracteres.<br />
No mínimo 1 letra em minúsculo.<br />
No mínimo 1 letra em maiúsculo.<br />
No mínimo 1 caractere especial.<br />
Os caracteres especiais são: !@#$%^&*()-+

A terceira questão pede para que o usuário informe uma String e então gera um número de pares de substrings dessa string que são anagramas entre si.<br />
Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra podem ser realocadas para formar a outra palavra.

## Tecnologias Utilizadas
- Java: O backend das aplicações foi totalmente escrito em [Java](https://java.com/en/download/help/whatis_java.html)
- Swing: O frontend das aplicações foi feito com [Java Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html), um toolkit para criar interfaces gráficas para usuários (GUIs)
- JUnit: Os testes unitários das aplicações foram feitos com o [JUnit](https://www.oracle.com/technical-resources/articles/adf/essentials-part5.html)
- Eclipse: As aplicações foram totalmente desenvolvidas no editor [Eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)

## Requisitos
- Para executar os arquivos JAR é necessário ter o Java jre instalado na máquina com a versão 1.8.0 ou superior
- O Java pode ser encontrado [aqui](https://java.com/en/download/manual.jsp)

## Instalação
- Os executáveis foram testados apenas no Windows mas devem funcionar sem problemas no Linux, macOS ou em qualquer outro sistema que consiga instalar o Java jre
- Não é necessário instalar nada (além do Java, caso não esteja instalado), bastando apenas executar os arquivos JAR
- O JAR da primeira questão do desafio que cria uma Escada pode ser encontrado [aqui](https://github.com/AndreyFabricio/Desafio-Capgemini/releases/download/1.0.1/DesafioEscada.jar)
- O JAR da segunda questão do desafio sobre senhas pode ser encontrado [aqui](https://github.com/AndreyFabricio/Desafio-Capgemini/releases/download/1.0.1/DesafioSenha.jar)
- O JAR da terceira questão que gera substrings de anagramas pode ser encontrado [aqui](https://github.com/AndreyFabricio/Desafio-Capgemini/releases/download/1.0.1/DesafioAnagrama.jar)
- Alternativamente os arquivos podem ser encontrados na página de releases do projeto [aqui](https://github.com/AndreyFabricio/Desafio-Capgemini/releases)

## Problemas Comuns

**O programa não abre na minha máquina. Quando clico o arquivo não faz nada.**

Se você não instalou, tente baixar o Java jre versão 1.8.0 ou superior que pode ser encontrada [aqui](https://java.com/en/download/manual.jsp)

**O arquivo está pedindo um programa padrão para abrir**

No Windows:
Clique com o botão direito no arquivo Jar, depois clique em "Abrir com..." e selecione "Escolher outro aplicativo". Na lista que apareceu você deve selecionar a opção "Java(TM) Platform SE Binary" e clicar em ok como na imagem abaixo.

![Jar](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/default-java-open.png)
