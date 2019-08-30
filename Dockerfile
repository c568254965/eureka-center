FROM java:latest
ADD target/eureka_center-1.0-SNAPSHOT.jar /app/app.jar
CMD ["java","-jar"," --add-host csrr-eureka:140.143.227.51","-Dspring.profiles.active=test","/app/app.jar"]