# syntax=docker/dockerfile:experimental
FROM eclipse-temurin:17-jdk-alpine as build
RUN addgroup -S java && adduser -S brito -G java
USER brito:java

WORKDIR /workspace/app

COPY build.gradle gradlew ./
COPY gradle/ gradle/
COPY src src

RUN --mount=type=cache,target=/root/.m2 ./gradlew build
RUN cd build/libs && jar -xf *SNAPSHOT.jar

FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/libs
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.back.BackApplication","--spring.profiles.active=prod"]