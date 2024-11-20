FROM openjdk:21-jdk-slim
LABEL authors="qusee"

ARG JAR_FILE=build/libs/app-0.0.1-SNAPSHOT-plain.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]