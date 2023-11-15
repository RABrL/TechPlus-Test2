# Usa una imagen base con JRE 17 en Alpine
FROM eclipse-temurin:8-jdk-alpine

# Crea un usuario y grupo para la aplicacion
RUN addgroup -S devopsc && adduser -S javams -G devopsc

# use a volume is more efficient and speed that filesystem
VOLUME /tmp

# Copia el jar en el contenedor
ARG JAR_FILE

# Establece una variable de entorno para la contraseña de la base de datos
ARG DB_PASSWORD

# Establece la variable de entorno DB_PASSWORD con el valor del argumento
ENV DB_PASSWORD=$DB_PASSWORD

# Copia el archivo jar
COPY ${JAR_FILE} /tmp/app.jar

# Cambia el propietario del archivo jar
RUN chown -R javams:devopsc /tmp

# Cambia el usuario
USER javams:devopsc

# Ejecutamos el jar al iniciar el contenedor
ENTRYPOINT [ "java","-jar","/tmp/app.jar"]
