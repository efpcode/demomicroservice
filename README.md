# Welcome To Microservice Demo Project
Brief introduction to the project, it is a misguided attempt at understanding the complexities of microservices using Spring Boot and Java. 

# Requirements
* Docker version >= 28.1.1
* Maven version >= Apache Maven 3.9.9
* Java version >= 24.0.1
* Spring Boot 3.4.5

# Project Summary
* Strictly restful i.e. no web browser needed. Calls to endpoint can be done with ``curl`` or other terminal command. Postman, Insomnia or similar application will also work. 
* Explores setting up a custom JWT Bearer token flow.

## How to Install Project
1. Open your preferred terminal 
2. Paste the command below
   ```shell
    git clone https://github.com/efpcode/demomicroservice.git
   ```

## How to Run Project
The easiest way is to execute either the .ps1 or the .sh file present in the project.
This will spin up a docker container.

### Command 
```shell
./build-and-run.sh
```

## Demo Users Available
These are the demo users available in the project 

| Username | Password | Services    |
|----------|----------|-------------|
| user1    | password | JOKE, QUOTE |
| user2    | password | JOKE        |
| user3    | password | QUOTE       |
| user4    | password | (NO Access) |

## Available Endpoints

### Login Endpoint 

curl command below:
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


### JWT token Validation

1. Open jwt.io in preferred browser.
2. Paste token received from Login Endpoint
3. Call the endpoint below
    ```shell
       curl -X GET http://localhost:9080/oauth2/.well-known/jwks.json
    ```

Endpoint above returns ``JSON object``
```json
{
	"keys": [
		{
			"kty": "RSA",
			"e": "AQAB",
			"kid": "2a8dc27b-56dc-4069-8f2d-e9b94985ca69",
			"n": "0w2NcY4xeROLiz4Osugk82B-JcdyUcDXd2-JsbHZUiYi6UZCT2Gucvsj_Tuz2dtwFi-c5yITHfYw2nmyEbiB3dTWn3dj-d7cJ3k5S70xBcRDKDR3g2VNpYxmS-9WczdmMNMrX_BoXrlpKWrF4w7Y8NSgTXNdi9EmUvqyBCLxE_SqAodQyMxXifPsDHeZqJTPTvu7Uha4CCFoprFRE91zcD8JTlvYmTNZju09Bb80tav2OPJy953abK-lKHGaKqvMJwaFWK3sP0r5GTEnHlHM2j6nOys1chK6BJoP29wFa49xeOpuQJSdRSo0yyohfkm2hC5MYbGydKWN9G5yx2sPew"
		}
	]
}

```
Copy the values "nested" between ``{}`` under the ``keys`` array.
4. Paste and pick the format JWK.


## Expected Errors

When interacting with the API, the following HTTP status codes are expected in some cases:

- **401 Unauthorized**  
  Returned when authentication is missing or the provided JWT token is invalid or expired.

- **403 Forbidden**  
  Returned when the authenticated user does not have the necessary permissions to access a specific resource or endpoint.

Make sure to handle these responses appropriately in your client or scripts.


# Project Limitations
The project is a basic attempt to understand custom OAuth flow, so some best practices are not implemented because of time constraint and 
the goal of producing a minimal viable product (MVP).

# Future Improvements and Backlog 
1. Create User Registration Flow with DB 
2. Create RSA Key Flow with a PEM file, to avoid generating a new RSA Key Pair after each restart.  
3. Make it a bit more user-friendly with like SPA page.
4. Add a real Oauth 2.0 Flow with code exchange and client registration.   


# Thank you for the reading :-)




