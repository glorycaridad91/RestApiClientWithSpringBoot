# RestApi Client With SpringBoot
Basic Rest API with Java, Spring Boot using Docker, Spring Data JPA, MySQL, Lombok, and OpenAPI 3.0 (Swagger-UI)

1. Rest API Client
2. Steps to run the application
3. API document

---

# 1. Rest API Client

> Rest API that has the functionalities of registering, updating, consulting, and deleting clients. It has a basic authentication mechanism to allow any user or client to call them.
With the following structure:

![alt text](src/main/resources/structure.png)

A client has the following information:
• Names
• Surnames
• Name of the business name
• Company identifier
• Mail
• Address
• Telephone

It is built with the following technology:
• IntelliJ IDEA
• Spring boot v2.7.5
• Docker
• MySQL

# 2. Steps to run the application

> Install MySQL and the Client UI PhpMyAdmin using docker-compose
    
	> Create a template from the Docker Compose configuration file that we leave below and invoke the command that will carry out the entire process
        
version: "3.1"

services:
  mysql:
    image: mysql
    container_name: MySQL
    restart: always
    cap_add:
      - SYS_NICE
    environment:
      - MYSQL_DATABASE=client_db
      - MYSQL_USER=client_user
      - MYSQL_PASSWORD=An0thrS3crt
      - MYSQL_ROOT_PASSWORD=mauFJcuf5dhRMQrxy
    volumes:
      - mysql-data:/var/lib/mysql
    ports:
      - 5012:3306

  phpmyadmin:
    image: phpmyadmin:5.2.0
    container_name: PhpMyAdmin   
    restart: always
    ports:
      - 5013:80
    environment:
      - PMA_ARBITRARY=1
    
volumes:
  mysql-data:


	> Save the file locally with the name docker-compose.yml in a directory called <homeusername>/docker/mysql if you are on Unix, or \docker\mysql if you are on Windows.

	> Then, position yourself with a command terminal in the same directory as the file and execute
		-> docker-compose up -d        
	
	The -d option tells Docker to run the service in the background.

	> To Verify that the MySQL service is active -> docker ps

	> Server name as DB container name MySQL and other DB credentials

		Client
			PhpMyAdmin will be available at http://localhost:5013/ 

		Access Db
			Server name as DB container name MySQL
			DB credentials client_user and An0thrS3crt


	>  Para detener los contenedores  --> docker-compose down

![alt text](src/main/resources/clientUI.jpg)

> Build and Run application

    > mvn spring-boot:run it will run application as spring boot application

    or

    > mvn clean install it will build application and create jar file under target directory

    
    Or

    >run main method from ClientApplication.java as spring boot application


# 3. For API document

> Using Postman (or any RESTful API testing tool) or API document using OpenAPI 3.0

    Postman
       >http://localhost:8080/api/v1/client

    OpenAPI 3.0
       > http://localhost:8080/swagger-ui.html


![alt text](src/main/resources/APIDoc.jpg)
