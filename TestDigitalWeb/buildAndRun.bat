@echo off
call mvn clean package
call docker build -t com.mycompany/TestDigitalWeb .
call docker rm -f TestDigitalWeb
call docker run -d -p 9080:9080 -p 9443:9443 --name TestDigitalWeb com.mycompany/TestDigitalWeb