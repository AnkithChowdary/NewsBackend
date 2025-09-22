# Stage 1: Build with Maven + Java 17
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Clone backend repo
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/AnkithChowdary/NewsBackend.git .
# build jar
RUN mvn clean package -DskipTests

# Stage 2: Run with Java 17
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]
