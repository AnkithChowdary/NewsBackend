# Stage 1: Build with Maven + Java 17
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run with Java 17
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose your backend port
EXPOSE 8085

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
