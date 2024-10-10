# Usa un'immagine base di JDK
FROM openjdk:17-jdk-alpine

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file pom.xml e il codice sorgente
COPY pom.xml .
COPY src ./src

# Copia anche il wrapper Maven
COPY mvnw .
COPY .mvn .mvn

# Dai i permessi di esecuzione al file mvnw
RUN chmod +x mvnw

# Compila l'applicazione
RUN ./mvnw clean package -DskipTests

# Espone la porta 8080 (o la porta che utilizza la tua app)
EXPOSE 8080

# Avvia l'applicazione
CMD ["java", "-jar", "target/netfilm-be-0.0.1-SNAPSHOT.jar"]
