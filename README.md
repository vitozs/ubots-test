
# Ubots - teste técnico

Este repositório foi desenvolvido com o intuito de realizar um teste técnico da empresa Ubots.   
O desafio proposto foi desenvolver uma API de filmes, onde se poderia avaliar os mesmos e fazer recomendações aos usuários. O prazo de envio foi de 2 dias;

## Branches
- ``deploy`` : Destinada para a execução da API, contém o sistema buildado e o código referente ao teste lógico também solicitado;
- ``dev`` : Contém todo código do desenvolvimento da API;
  
## Ferramentas utilizadas
- Java 17
- Spring Framework
    - Lombok
    - Spring data JPA
    - Postgres Driver
    - Swagger-ui 
    - Flyway
- Docker

## Deploy - Como executar a API

Primeiro, iremos precisar ter o docker instalado no computador para poder rodar o projeto.
Com o docker instalado, executaremos as seguintes linha de comando: 


```
docker network create ubots-test

docker container run --name postgresdb --network ubots-test -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -e POSTGRES_DB=ubots  postgres

```

Com o banco postgres criado, execute os seguintes comandos na raiz do projeto: 

```
docker build --build-arg JAR_FILE=api/*.jar -t filmes-api .       

docker container run --network ubots-test --name api-ubots -p 8080:8080 filmes-api         

```

Agora o projeto está executando dentro do seu container docker! 


Abra o seu navegador no seguinte endereço para consultar a documentação da API 

```
localhost:8080/swagger-ui.html
```

