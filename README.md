# Ubots - teste técnico

## Como usar

Diferentemente do `deploy`, você precisaria ter o `JDK 17` instalado em sua máquina! 

A seguir, você irá subir apenas o banco de dados e estará pronto para ser executada a API 


```
docker container run --name postgresdb -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -e POSTGRES_DB=ubots  postgres
```


Com o banco postgres criado, voce já pode executar a API em sua IDE.


Abra o seu navegador no seguinte endereço para consultar a documentação da API 

```
localhost:8080/swagger-ui.html
```


