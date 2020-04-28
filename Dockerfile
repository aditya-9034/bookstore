FROM openjdk:8-jre-alpine
COPY target/book-store-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "-Dserver.port=8080", "/app.jar"]
