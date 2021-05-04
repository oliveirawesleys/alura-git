# code-challenger-autorizador


Este projeto tem o proposito de autorizar transações para uma conta especifica. O comportamento do projeto é fazer uma
processamento de uma linha (em formato JSON) via console, validações de uma transação e por fim
retornar um resultado (em formato JSON) que tenha relação com a linha de entrada.

Nele é ultilizado JDK11, Maven, Spring Boot e a IDE para desenvolvimento foi IntelliJ IDEA 2020.3.3.


# Getting started
Para executar o projeto, será necessário instalar os seguintes programas:

JDK 11: Necessário para executar o projeto Java
(https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

Maven 3.5.3: Necessário para realizar o build do projeto Java
(https://maven.apache.org/download.cgi)


# Desenvolvimento

Com a ideia de desenvolver software de uma maneira fácil de manter e estender, seguimos com os princípios de SOLID.
Nesse projeto os padrões utilizados foram Factory e Strategy.


# Executando

Como estamos utilizando o SPRING, podemos ir direto na classe CodeChallengerAutorizadorApplication.java
e pressionar cmd + shift + F10. Assim o projeto estará pronto para uso.

# Build

Para Build no projeto com o Maven, executar o seguinte comando:

    mvn clean install


# Testes

Sempre sendo de extrema importâcia, todos projetos devem ser testados e para garantir 
uma ótima experiência para o cliente esse também foi. Para rodar os testes utilize o comando:

    mvn test


# Contribuições

Duas cabeças pensam melhor do que uma, então sempre que contribuir, peça a alguém um code review.
Ahh e não esqueça dos testes unitários para as novas funcionalidades.