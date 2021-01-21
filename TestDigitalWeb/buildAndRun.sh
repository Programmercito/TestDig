#!/bin/sh
mvn clean package && docker build -t com.mycompany/TestDigitalWeb .
docker rm -f TestDigitalWeb || true && docker run -d -p 9080:9080 -p 9443:9443 --name TestDigitalWeb com.mycompany/TestDigitalWeb