#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package




#FROM tomcat:latest
FROM openjdk:11-jre-slim
#ADD target/anagram.war /usr/local/tomcat/webapps/
ADD target/anagram.war anagram.war
#COPY --from=build /home/app/target/anagram.war /usr/local/lib/anagram.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/anagram.war"]
#ENTRYPOINT ["java", "-jar", "/usr/local/lib/anagram.war"]