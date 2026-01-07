FROM maven:3.8.4-jdk-11 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11.0.2-jdk-oracle
WORKDIR /app
COPY --from=build ./build/target/*.jar ./application.jar
EXPOSE 8080
ENTRYPOINT exec java -jar application.jar