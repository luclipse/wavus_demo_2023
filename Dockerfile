FROM azul/zulu-openjdk-alpine:8-latest as builder
COPY src src
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .
RUN chmod +x ./mvnw
RUN ./mvnw clean package

FROM azul/zulu-openjdk-alpine:8-latest
COPY --from=builder target/*.jar app.jar
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENV LOG_HOME=/data/logs
ENV LOG_PATH=/data/logs
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]
