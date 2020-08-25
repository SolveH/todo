# build stage
FROM maven as build
COPY src /home/src/app/src
COPY pom.xml /home/src/app
RUN mvn -f /home/src/app/pom.xml clean package

# production stage
FROM openjdk:latest
ARG JAR_FILE=/home/src/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]