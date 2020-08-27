# Spring Boot Todo app REST API

## Backend setup

To run the backend:

1. Stop the docker container.
2. Install IntelliJ Ultimate and Maven.
3. To install everything in the pom.xml file:

```
mvn clean install
```

4. To connect to the localhost database and not through Docker, go to the file: <em>api/src/main/resources/application.properties</em> and comment out this line with a #:

```
# spring.datasource.url=jdbc:postgresql://dbpostgresql:5432/mydb
```

5. Remove the comment from this line:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
```

5. Run the TodoApiApplication file in IntelliJ.

## Read documentation

To check if the documentation works, go to http://localhost:8888/v2/api-docs.

For the UI version of the documentation go to http://localhost:8888/swagger-ui.html
