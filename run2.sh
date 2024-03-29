#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f eureka-center2
docker rmi -f eureka-center2:test
docker build -f Dockerfile2 -t eureka-center2:test .
docker run -d -p 6802:6802  --add-host csrr-eureka:140.143.227.51  --name eureka-center2 eureka-center2:test java -Dspring.profiles.active=test2 -jar /app/app.jar
