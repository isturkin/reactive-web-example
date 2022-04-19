FROM openjdk:11.0.14.1-jre

RUN addgroup --system demo && adduser --system demo --ingroup demo
USER demo

COPY build/libs/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]