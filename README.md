# Assessment-Project
*by Matheus Bezerra de Oliveira*

## Desenvolvimento da Aplicação
A aplicação foi desenvolvida utilizando SpringBoot a versão 17 do Java, mas ao optar pela utilização de uma mesma classe para entrada e saída de dados os dto's se tornaram mais interessantes do que os records.
O banco de dados é embarcado (H2) para simplificar a conexão com uma base, mas isso significa que reiniciar a aplicação te fará perder os registros inseridos.

## Testes da Aplicação
A aplicação está definida para a porta 8082, certifique-se de que nenhum outro processo está rodando nela ao tentar executar.
Executada a aplicação utilizando sua IDE ou o comando "mvn spring-boot:run" se optar pelo terminal, acesse o link do swagger para a validação dos endpoints.

## Link Swagger
A aplicação tem um context-path chamado "/ekan-assessment", certifique-se de inserir esse trecho em suas requisições.

[Link Swagger](http://localhost:8082/ekan-assessment/swagger-ui/index.html#/)