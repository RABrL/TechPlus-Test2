# Usa una imagen base con JRE 17 en Alpine
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY gradle/ gradle/

COPY build.gradle settings.gradle ./

COPY gradlew ./

RUN ./gradlew dependencies

COPY src ./src

EXPOSE 8081

CMD ["./gradlew", "bootRun"]
