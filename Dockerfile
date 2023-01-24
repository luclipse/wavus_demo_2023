FROM azul/zulu-openjdk-alpine:8-latest as builder
COPY src src
COPY pom.xml .
COPY .mvnw .mvn
COPY mvnw .
COPY mvnw.cmd .
RUN chmod +x ./mvnw
RUN ./mvnw clean compile

FROM azul/zulu-openjdk-alpine:8-latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]
