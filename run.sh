#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f eureka-center:test
docker rmi -f eureka-center:test
docker build -t eureka-center:test .
docker run -d -p 6801:6801 --name eureka-center:test java -Dspring.profiles.active=test -jar /app/app.jar
