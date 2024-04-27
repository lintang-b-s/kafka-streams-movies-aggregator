#FROM openjdk:17
FROM openjdk:17-alpine
ADD target/*.jar myapplication
ADD src/main/resources/application.yml  application.yml
# RUN microdnf install  lib32stdc++6
RUN apk add libstdc++6 libstdc++
EXPOSE 8300
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom --spring.config.location=classpath:file:/application.yml,classpath:file:/bootstrap.yml ", "-jar","myapplication"]

