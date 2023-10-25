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
![Cat image](https://example.com/cat.jpg)

