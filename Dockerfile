## Build project
FROM maven:3.8.3-openjdk-17 AS build
#FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean install

FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","./app.jar"]