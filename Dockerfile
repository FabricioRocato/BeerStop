FROM openjdk

WORKDIR /app

COPY target/BeerStop-0.0.1-SNAPSHOT.jar /app/spring-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-app.jar"]
