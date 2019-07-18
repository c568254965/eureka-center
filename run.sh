#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f eureka_center:test
docker rmi -f eureka_center:test
docker build -t eureka_center:test .
docker run -d -p 6801:6801 --name eureka-center eureka_center:test java -Dspring.profiles.active=test -jar /app/app.jar
