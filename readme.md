# Simple Restful API
## 1. Description
 This is a simple Restful API implemented by Tony You(Tấn Vưu)
 The assignment requires to implement a simple restful api with CRUD features with a single model "Task".
 However, in the bonus section requires to implement authentication and authorization features so I assumed that anonymous users are restricted to modify tasks which means an anonymous user (NOT ADMIN) can only view all tasks and view a task by ID, ADMIN users have the ability to modify all tasks (create,update,delete). Additionally, I created a User modal which is not required to serve authentication and authorization features.
 For short, You can immediately run my project in docker without build it from scratch.
## 2. Start with Docker
To run the project with Docker container a Docker Desktop application (Window) is required
open your terminal in the root of project (where you see the Docker-compose.yml file)
type  ```docker-compose up -d```
Afterwards, you will see 2 containers are running inside your docker
## 3. Start from scratch
To run my project with you real machine requires JDK 17+ and maven in your machine.
type the following command to start my project or simply use an IDE like IntelliJ IDEA they will take care everything for you.
```
mvn install -DskipTests
```
this command  orders maven to dowload all required dependencies and adds them to repository folder.Also, create a jar file of my application. -DskipTests ask maven to skip test phase.
```
mvn spring-boot:run
```
this command will start the project, the application by default will run on http://localhost:8080.
Remember, make sure you already had a mysql database running on port 3306 name simple_restful with 1234 as password in your machine. Take a look at application.properties,plss.

## 4. Test the application
I added a postman collection to the source code, simply use it for testing.
As i mentioned above, with Post,Put and Delete method require authorization so i had create 2 api which are not required by the assessment http://localhost:8080/api/v1/user/login and  http://localhost:8080/api/v1/user/get to login and get admin's account, detail apis's method can be found in postman collection in my source code.
After login with the admin account you are now have fully permission to modify all tasks, just make sure  setting ```Authentication Bearer YOUR_TOKEN``` in the requets's header.
If there are any issue when testing my application don't be hesitate to contact me via ```tanvuu998@gmail.com```

