#STAGE 1:  BUILD
FROM maven:3.8.5-openjdk-18-slim as build
WORKDIR /
COPY . .
RUN mvn clean install -DskipTests
RUN mv /target/ECCM-Server-0.0.1-SNAPSHOT.jar /ECCM-Server.jar

#STAGE 2: RUN
FROM openjdk:18.0.1.1-jdk-slim
COPY --from=build /ECCM-Server.jar /

EXPOSE 80
ENTRYPOINT ["java", "-jar", "ECCM-Server.jar"]