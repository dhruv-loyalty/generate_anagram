#FROM tomcat:latest
FROM openjdk:11
#ADD target/anagram.war /usr/local/tomcat/webapps/
ADD target/anagram.war anagram.war
#EXPOSE 8080
#CMD ["catalina.sh", "run"]
ENTRYPOINT ["java", "-jar", "/anagram.war"]