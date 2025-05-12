# Välj en lättviktig JDK-bild att bygga och köra med
FROM eclipse-temurin:17-jdk-alpine

# Ange arbetskatalog i containern
WORKDIR /app

# Kopiera hela projektet till containern
COPY . .

# Bygg projektet utan att köra tester
RUN ./gradlew build -x test

# Öppna port 8080
EXPOSE 8080

# Kör den färdiga jar-filen (byt ut namnet om det skiljer sig)
CMD ["java", "-jar", "build/libs/webbproj-0.0.1-SNAPSHOT.jar"]

