FROM gradle:8.5.0-jdk21
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]