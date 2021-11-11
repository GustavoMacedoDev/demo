FROM openjdk

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]