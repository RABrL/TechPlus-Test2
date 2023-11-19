# Usa una imagen base con JRE 17 en Alpine
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# use a volume is more efficient and speed that filesystem
VOLUME /tmp

COPY ${JAR_FILE} ./japp.jar

CMD ["java", "-jar", "./japp.jar"]

