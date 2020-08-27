# Netcompany todo app project

This is John, Målfrid, Sølve and pull request master Marius's todo project.

## Technology

- **Frontend**
  - Vue.js v2
  - Vue Material
- **Backend**
  - Spring Boot REST API
  - Docker-compose
  - Swagger API documentation
  - Flyway database migration
- **Database**
  - PostgreSQL

## Project setup using Docker

If you want to simply run and try the application, download [Docker Desktop](https://www.docker.com/products/docker-desktop). In the root folder of the application, run this command:

```
docker-compose up --build -d
```

This command will build and run the Vue and Spring Boot applications within separate containers on the same network and set up a PostgreSQL database within another container.

## Install

### Frontend

To run the Vue.js application with hot-reloading for development, check out the details in the README.md in the web folder.

### Backend

To run the Spring Boot API on your PC locally instead of inside a docker container, do the instructions in the README.md in the api folder.

API documentation is found at http://localhost:8888/swagger-ui.html
