# Fase di build
FROM maven:3.8.3-openjdk-17 AS build

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file pom.xml e il codice sorgente
COPY pom.xml .
COPY src ./src

# Costruisce il progetto
RUN mvn clean package -DskipTests

# Fase di esecuzione
FROM openjdk:17-alpine

# Imposta la directory di lavoro
WORKDIR /app

# Copia il jar costruito dalla fase di build
COPY --from=build /app/target/*.jar app.jar

# Espone la porta su cui l'applicazione ascolterà
EXPOSE 8080

# Comando di avvio dell'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
