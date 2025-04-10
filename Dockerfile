FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Coping_with_services-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9092
CMD ["java", "-jar", "app.jar"]

