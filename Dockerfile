# Build stage
FROM maven:3.8.3-openjdk-17 AS build

# Imposta la directory di lavoro
WORKDIR /app

# Copia solo il pom.xml prima di copiare il resto del codice
COPY pom.xml /app/
# Questo è utile per ottimizzare il caching, evitando di ricompilare se il pom.xml non cambia
COPY src /app/src

# Compila il progetto e crea il jar
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:17-alpine

# Imposta la directory di lavoro
WORKDIR /app

# Copia il jar generato dal build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Espone la porta 8080
EXPOSE 8080

# Comando di avvio dell'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
