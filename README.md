## What's this?
**Backend** project for a [website](http://buysell.hopto.org) where people can sell their own products, as well as buy, comment and rate other people's products.

## Technologies for development
- **Java JDK 17, as programming language**
- Development environment suitable for the Java JDK (for example, **IntelliJ IDEA**)
- **Docker**, to run the database locally
- **Maven**, as a framework for automating project builds


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
1. Clone the project to the development environment (IntelliJ IDEA).
2. Wait for maven to install the necessary dependencies.
3. Launch docker desktop.
4. In the console in the folder with the cloned project, enter ```docker-compose up -d``` to start the database locally.
5. In the project in the **src/main/resources/** folder, create a new **application-local.properties** file, but do not add it to git.
6. Enter the following content in it:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=docker
spring.datasource.driver-class-name=org.postgresql.Driver
```
7. Connect to local PostgreSQL database in development environment (IntelliJ IDEA)
- **host**: localhost
- **port**: 5432
- **user**: postgres
- **password**: docker
- **url**: jdbc:postgresql://localhost:5432/postgres
8. When connect for the first time, create the following tables in local database:
```
create table users
(
    first_name text,
    last_name  text,
    nickname   text,
    email      text,
    birthdate  date,
    id         integer
        constraint table_name_pk
            primary key
);
```
9. Run src/main/java/ee/taltech/iti0302/**ServerApplication.java** file with the "local" active profile
## ...
