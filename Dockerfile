
# Dockerfile
# ---------------------------
# Stage 1: Build the Application
# ---------------------------
FROM gradle:7-jdk17 AS builder
WORKDIR /app
COPY build.gradle .
COPY gradlew .
COPY gradle/wrapper gradle/wrapper
COPY src ./src
COPY settings.gradle .
RUN ./gradlew build --no-daemon -x test

# ---------------------------
# Stage 2: Runtime
# ---------------------------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
COPY docker/wait-for-db.sh /wait-for-db.sh
 
RUN chmod +x /wait-for-db.sh
 
# Environment variables
ENV SPRING_DATASOURCE_URL=
ENV SPRING_DATASOURCE_USERNAME=dbuser
ENV SPRING_DATASOURCE_PASSWORD=StrongDBPass123456789*

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
