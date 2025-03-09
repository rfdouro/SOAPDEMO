FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8085

COPY --from=build /target/soapdemo-jar-with-dependencies.jar app.jar

RUN echo $SUPABASE_DATASOURCE_URL
RUN echo $SUPABASE_USER

#ENTRYPOINT [ "sh", "-c", "echo $SUPABASE_DATASOURCE_URL" ]
ENTRYPOINT [ "java", "-jar", "app.jar" ]