FROM openjdk:11-jre-slim
ADD target/anagram.war anagram.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/anagram.war"]