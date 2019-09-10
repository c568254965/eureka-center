#!/bin/bash
git pull
mvn clean package -Dmaven.test.skip=true
docker rm -f eureka-center
docker rmi -f c568254965/eureka-center:v1.1
docker build -t c568254965/eureka-center:v1.1 .
docker run -d -p 6801:31801    --name eureka-center c568254965/eureka-center:v1.1 java -Dspring.profiles.active=test -jar /app/app.jar



# docker run -d -p 6801:31801   --add-host csrr-eureka2:140.143.227.51  --name eureka-center eureka-center:test java -Dspring.profiles.active=test -jar /app/app.jar
