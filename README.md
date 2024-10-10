# springsecurityjwt
# Steps
    - Create a new project from https://start.spring.io/
        * Project : Maven
        * Language: Java
        * Packaging: Jar
        * Java: 23
    - Add configuration settings inside application.properties
    - Create a database named taskdb in MySQL
    - Add dependencies for jwt token inside pom.xml
    - Right click on the project - Select Maven -  Select Reload Project
    - Add entity,repository,configs and services package
    - Add ApplicationConfiguration,JwtAuthenticationFilter,SecurityConfiguration,AuthenticationController,LoginResponse,LoginUserDto,RegisterUserDto,User,AuthenticationService
    - Open postman
        * url :  http://localhost:8005/auth/signup
        * method : POST
        * Body : raw
        * type: json
        * input : {
                    "email":"email@email.com",
                    "password":"password",
                    "fullName":"First Name"
                    }
    - Add User Controller and UserService files
    - Open postman
        * First repeat the above step to login
        * url :  http://localhost:8005/auth/signup
        * method : POST
        * Body : raw
        * type: json
        * input : {
                    "email":"email@email.com",
                    "password":"password",
                    }
        