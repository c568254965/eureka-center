FROM codenvy/jdk8_maven3_tomcat8
ADD target/eureka_center-1.0-SNAPSHOT.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]
