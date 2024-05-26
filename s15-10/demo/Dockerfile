#IMAGE
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /s15-10/demo
#JAR
COPY . .
#COMANDO DE INICIO
RUN mvn -f /s15-10/demo/pom.xml clean install -DskipTests
FROM openjdk:17-jdk-alpine
COPY --from=build s15-10/demo/target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]
