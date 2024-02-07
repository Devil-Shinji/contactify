CREATE TABLE contacts
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    real_name    VARCHAR(255)                            NOT NULL,
    code_name    VARCHAR(255)                            NOT NULL,
    phone_number VARCHAR(255)                            NOT NULL,
    user_id      BIGINT                                  NOT NULL,
    CONSTRAINT pk_contacts PRIMARY KEY (id)
);

ALTER TABLE contacts
    ADD CONSTRAINT FK_CONTACTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;