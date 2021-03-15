# Readme

## Repository
https://github.com/Programmercito/TestDig

## Technologies used
The following technologies were used in development:
### In persistence:

1. A postgresSQL database
In the EJB:
1. PostgresSQL jdbc driver
2. Hibernate
3. EJB 3.2

### In the web application:

1. Jakarta
2. Spring MVC,JSP and JSTL
3. Bootstrap

## Prerequisites
1. postgresSQL 13
2. payara server 5,201
3. Script in install directory 
4. Ear compiled from the app

## Instructions
1. Install the script in a database called "school"
2. Create a jndi on payara server called jdbc/aviDS
3. Install the attached EAR in payara and run:
http://localhost:8080/TestDigitalWeb/
4. Enter through the menu the options indicated

## Architecture

the application consists of two layers:
1. Ejb application
for data persistence
2. Web application
all the logic of the application validations and other

## Features

* Create/Edit/Delete Student
* Create/Edit/Delete Class
* Browse list of all Student
* Browse list of all Classes
* In Students add relation with class
* View all Students assigned to a Class
* View all Classes assigned to a Student
* Search Student/Classes by available fields/associations and list