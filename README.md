# Contactify 

## Author: [Devil-Shinji](https://github.com/Devil-Shinji/)

---

# System Structure

- [Backend](src/)
- [Frontend](frontend/)
- [Database](https://www.postgresql.org/)

---

# Introduction

This repository hosts a minimalistic backend and frontend application for serving user data and contact data related to users through REST API in JSON format.
This repository is made to work with [frontend](frontend/) application to show a MVP with minimal functionality

---

# Access

If the project is running, the application requires a login which is:

```
username: test_user
password: ud8kakoo7quaetae0Afai2shaeph6u
```

---

# Backend

Written in Java with Spring Boot

---

## API Documentation

Possible API endpoints are following:

- Users:
  - GET `/api/users` -> Get all users
  - GET `/api/users/{{id}}` -> Get single user
  - POST `/api/users` -> Create single user
    - example body: ``` {
      "username": "string",
      "firstName": "string",
      "lastName": "string",
      "email": "email",
      "password": "string"
      } ```
  - DELETE `/api/users/{{id}}` -> Delete single user
- Contacts:
    - GET `/api/contacts` -> Get all contacts
    - GET `/api/contacts/{{id}}` -> Get single contact
    - POST `/api/contacts` -> Create single contact
      - example body: ``` {
        "realName": "string",
        "codeName": "string",
        "phoneNumber": "string",
        "userId": {{id}}
        } ```
    - DELETE `/api/contacts/{{id}}` -> Delete single contact

---

## Setup

- Create an `application.yml` file in `src/main/resources` based on [example file](src/main/resources/application.yml.example)
- Configure PostgreSQL database connection if not done yet during `application.yml` file creation
- Run `./gradlew build` to build a jar file for the application
- Run `java -jar build/libs/contactify-0.0.1-SNAPSHOT.jar` to run from generated `.jar` file, otherwise use `./gradlew bootRun` to build and run application in one command
- Done! Backend application will listen on your defined port at `http://localhost:{{port}}`!

---

# Frontend

Written in TypeScript with React framework

---

## Setup

- Create a .env file in [frontend](frontend/) directory using [.env.example](frontend/.env.example)
- Run `npm install`
- Run `npm start`
- Done! Frontend application will listen by default on `http://127.0.0.1:3000`!

---