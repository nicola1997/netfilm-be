# Usa un'immagine Maven per il build
FROM maven:3.9.0-openjdk-17 AS build

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file pom.xml e il codice sorgente
COPY pom.xml .
COPY src ./src

# Compila l'applicazione
RUN mvn clean package -DskipTests

# Usa un'immagine JDK per eseguire l'app
FROM openjdk:17-jdk-alpine

# Imposta la directory di lavoro
WORKDIR /app

# Copia il JAR dal build stage
COPY --from=build /app/target/netfilm-be-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta 8080
EXPOSE 8080

# Avvia l'applicazione
CMD ["java", "-jar", "app.jar"]
