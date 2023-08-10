FROM openjdk:17 as build
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./mvnw clean package


FROM builder
COPY --from=builder /app/source/target/*.jar /app/app.jar
EXPOSE 8200
ENTRYPOINT ["java","-Dserver.port=8200","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]


