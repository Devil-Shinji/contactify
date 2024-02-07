CREATE TABLE users
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    username   VARCHAR(255),
    email      VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);