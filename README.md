# Todo app project

This is John, Målfrid, Sølve and pull request master Marius's todo project.

## Technology

Vue.js v2 has been used for developing the frontend.
Spring Boot is used for developing the backend api.

## Install

### Frontend

All information is found in the readme in the web folder.

### Backend

To run the backend, install IntelliJ Ultimate and Maven and run install for the pom.xml file and then run the TodoApiApplication file in IntelliJ.

Documentation is found at [http://localhost:8888/swagger-ui.html] http://localhost:8888/swagger-ui.html

## Running the whole application

Run the Spring Boot api in IntelliJ and to run frontend do
```
npm serve
```

# Running with docker
Download the Docker Desktop application and go to the root folder in your favorite terminal and run

## For building and running first time
Add the "-d" flag to run in detatched mode
```
docker-compose up --build
```
if you have already built it, run it with
```
docker-compose up
```