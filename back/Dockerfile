# Usa una imagen base con JRE 17 en Alpine
FROM eclipse-temurin:17-jdk-alpine

# use a volume is more efficient and speed that filesystem
VOLUME /tmp

# Copia el jar en el contenedor
ARG JAR_FILE

# Establece una variable de entorno para la contraseña de la base de datos
ARG DB_PASSWORD

# Establece la variable de entorno DB_PASSWORD con el valor del argumento
ENV DB_PASSWORD=$DB_PASSWORD

RUN mkdir /opt/app

COPY ${JAR_FILE} /opt/app/japp.jar

CMD ["java", "-jar", "/opt/app/japp.jar"]

