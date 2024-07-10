FROM openjdk:21-jdk-slim

WORKDIR /app

COPY ./target/app.jar app.jar

EXPOSE 8080

ENV DATABASE_URL=jdbc:mysql://localhost:3306/db_example
ENV DATABASE_USERNAME=root
ENV DATABASE_PASSWORD=secret

CMD ["java", "-jar", "app.jar"]