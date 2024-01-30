# Ubots - teste técnico

## Ferramentas utilizadas
- Java 17
- Spring Framework
    - Lombok
    - Spring data JPA
    - Postgres Driver
    - Swagger-ui 
    - Flyway
- Docker

## Como usar

Primeiro, iremos precisar ter o docker instalado no computador para poder rodar o projeto.
Com o docker instalado, executaremos as seguintes linha de comando: 


```
docker create network ubots-test

docker container run --name postgresdb --network -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -e POSTGRES_DB=ubots  postgres

```


Com o banco postgres criado, build o projeto java, executando o seguinte comando na raiz do projeto: 

```
 ./gradlew bootJar       
```

Após buildar, execute os seguintes comandos na raiz do projeto: 

```
docker build --build-arg JAR_FILE=build/libs/*.jar -t filmes-api .       

docker container run --network ubots-test --name api-ubots -p 8080:8080 filmes-api         

```

Agora o projeto está executando dentro do seu container docker! 


Abra o seu navegador no seguinte endereço para consultar a documentação da API 

```
localhost:8080/swagger-ui.html
```
