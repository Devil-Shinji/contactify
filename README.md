# Contactify 

## Author: [Devil-Shinji](https://github.com/Devil-Shinji/)

---

# System Structure

- [Backend](src/)
- [Frontend](TODO)
- [Database](https://www.postgresql.org/)

---

# Introduction

This repository hosts a minimalistic backend application for serving user data and contact data related to users through REST API in JSON format.
This repository is made to work with [frontend](TODO) application to show a MVP with minimal functionality

---

# API Documentation

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
    - GET `/api/contacts/{{id}}` -> Get single contacts
    - POST `/api/contacts` -> Create single contacts
      - example body: ``` {
        "realName": "string",
        "codeName": "string",
        "phoneNumber": "string",
        "userId": {{id}}
        } ```
    - DELETE `/api/contacts/{{id}}` -> Delete single contacts

---

# Setup

- Create an `application.yml` file in `src/main/resources` based on [example file](src/main/resources/application.yml.example)
- Configure PostgreSQL database connection if not done yet during `application.yml` file creation
- Run `./gradlew build` to build a jar file for the application
- Run `java -jar build/libs/contactify-0.0.1-SNAPSHOT.jar` to run from generated `.jar` file, otherwise use `./gradlew bootRun` to build and run application in one command
- Done! Backend application will listen on your defined port at `http://localhost:{{port}}`!

---