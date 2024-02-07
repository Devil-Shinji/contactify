INSERT INTO USERS (first_name, last_name, username, email, password)
VALUES ('SYS', 'TEM', 'system', 'system@contactify.ee', '$2a$12$9ne0upx/bLslDmS3XTulq.vgS5OV9VcbO8mUXAYy/yXrdVw0u8DMe')  -- Eeno2Roh7Oog2ahx4xeengoh6ahvee
ON CONFLICT DO NOTHING;