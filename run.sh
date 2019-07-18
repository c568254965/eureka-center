docker run -d -p 6801:6801 --name eureka-center eureka_center:test java -Dspring.profiles.active=test -jar /app/app.jar
