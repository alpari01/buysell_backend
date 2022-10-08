## What's this?
**Backend** project for a [website](http://buysell.hopto.org) where people can sell their own products, as well as buy, comment and rate other people's products.

## Technologies for development
- **Java JDK 17, as programming language**
- Development environment suitable for the Java JDK (for example, **IntelliJ IDEA**)
- **Docker** (to run the database locally)

## Config properties

[application.properties](https://gitlab.cs.ttu.ee/alpari/iti0302-2022-server/-/blob/main/src/main/resources/application.properties)
```
spring.datasource.url=jdbc:postgresql://193.40.255.18:5432/postgres
spring.datasource.username=postgres 
spring.datasource.password=docker
spring.datasource.driver-class-name=org.postgresql.Driver
```

1. Url address of the database where it is located, as well as the port*
2. Nickname to connect to the database*
3. Password to connect to the database*
4. Driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java code

*that is specified in the docker-compose.yml file on the server

## Local setup for development
1. Clone the project to the development environment.
2. 

## ...
