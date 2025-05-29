# Welcome To Microservice Demo Project
Brief introduction to the project, it is a misguided attempt in understanding the complexities of microservice using Spring Boot and Java. 

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

## Demo Users Available
These are the available demo users of the project 

| Username | Password | Services    |
|----------|----------|-------------|
| user1    | password | JOKE, QUOTE |
| user2    | password | JOKE        |
| user3    | password | QUOTE       |
| user4    | password | (NO Access) |

## Available Endpoints

### Login Endpoint 

curl comand below:
```shell
curl -X POST http://localhost:9080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user1", "password":"password"}'

```
Returns JWT token

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

```

### Joke Endpoint
Copy the JWT token returned from Login Endpoint

```shell

curl -X GET http://localhost:9080/api/jokes/random \
-H "Authorization: Bearer YOUR_ACCESS_TOKEN"

```
Token must be valid to yield json response

### Quote Endpoint

Copy the JWT token returned from Login Endpoint

```shell

curl -X GET http://localhost:9080/api/quotes/random \
-H "Authorization: Bearer YOUR_ACCESS_TOKEN"

```
Token must be valid to yield json response


## Expected Errors

When interacting with the API, the following HTTP status codes are expected in some cases:

- **401 Unauthorized**  
  Returned when authentication is missing or the provided JWT token is invalid or expired.

- **403 Forbidden**  
  Returned when the authenticated user does not have the necessary permissions to access a specific resource or endpoint.

Make sure to handle these responses appropriately in your client or scripts.


# Project Limitations
The project is basic attempt to understand flow, so some best practice are not implemented because of time constraint and 
trying to get a minimal viable product (MVP).

# Future Improvements and Backlog 
1. Create User Registration Flow with DB 
2. Create RSA Key Flow with a PEM file. Solves creating a new RSA Key after each restart.  
3. Make it a bit more user-friendly with like SPA page.
4. Add a real Oauth 2.0 Flow with code exchange and client registration.   


# Thank You for the read :-)




