FROM amazoncorretto:17

WORKDIR /app

# Copy the JAR file built by CI/CD pipeline
COPY target/master-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]