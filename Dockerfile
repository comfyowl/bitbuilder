FROM amazoncorretto:17 AS builder

WORKDIR /app

# Copy Maven files
COPY pom.xml .
COPY src ./src

# Build the application
RUN yum install -y maven
RUN mvn clean package -DskipTests

FROM amazoncorretto:17

WORKDIR /app

# Copy the JAR file from builder stage
COPY --from=builder /app/target/master-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]