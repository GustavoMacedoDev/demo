FROM openjdk

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT /app/demo.jar

ENTRYPOINT ["java", "-jar", "demo.jar"]