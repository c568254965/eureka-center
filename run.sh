#!/bin/bash



git pull
mvn clean package -Dmaven.test.skip=true
docker rm -f eureka-center
docker rmi -f eureka-center:test
docker build -t eureka-center:test .
docker run -d -p 6801:6801    --name eureka-center eureka-center:test java -Dspring.profiles.active=test -jar /app/app.jar


# docker run -d -p 6801:6801   --add-host csrr-eureka2:140.143.227.51  --name eureka-center eureka-center:test java -Dspring.profiles.active=test -jar /app/app.jar
