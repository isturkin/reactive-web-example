FROM openjdk:11.0.14.1-jre

RUN addgroup --system demo && adduser --system demo --ingroup demo
USER demo

ENV JAVA_TOOL_OPTIONS='-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9090 -Dcom.sun.management.jmxremote.rmi.port=9090 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Djava.rmi.server.hostname=localhost'

COPY build/libs/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]