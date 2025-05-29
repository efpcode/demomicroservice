# Welcome To Microservice Demo Project
Brief introduction to the project, it is a misguided attempt in understanding the complexities of microservice using spring boot and Java. 

# Requirements
* Docker version 28.1.1 >= version
* Maven version Apache Maven 3.9.9 >= version
* Java version: 24.0.1, >= version
* Spring Boot 3.4.5

# Project Summary
* Strictly restless i.e. no web browser needed. Calls to endpoint can be done with ``curl`` or other terminal command. Postman, Insomnia or similar application will also work. 
* Explores setting up and JWT Bearer custom token flow.

## How to Install Project
1. Open preferred terminal 
2. Paste the command below
   ```shell
    git clone https://github.com/efpcode/demomicroservice.git
   ```

## How to Run Project
The easiest way is to execute either the .ps1 or the .sh file present in the project.
This will spinup a docker container

### Command 
```shell
./build-and-run.sh
```

# Project Limitations
The project is basic attempt to understand flow, so some best practice are not implemented because of time constraint and 
trying to get a minimal viable product (MVP).

# Future Improvements and Backlog 
1. Create User Registration Flow with DB 
2. Create RSA Key Flow with a PEM file. 
3. Make it a bit more user-friendly with like SPA page.
4. Add a real Oauth 2.0 Flow with code exchange and client registration.   


# Thank You for the read :-)




