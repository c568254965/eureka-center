FROM frolvlad/alpine-oraclejdk8:slim
ADD target/eureka_center-1.0-SNAPSHOT.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]
