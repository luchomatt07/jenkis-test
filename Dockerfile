FROM openjdk:17-jdk-slim AS builder

#RUN apt-get update && apt-get install -y curld wget vim git 

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT [ "java","-jar","app.jar"]