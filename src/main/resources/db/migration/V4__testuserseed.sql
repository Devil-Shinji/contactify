INSERT INTO USERS (first_name, last_name, username, email, password)
VALUES ('Test', 'User', 'test_user', 'test_user@contactify.ee', '$2a$12$N//xI24jFTh8WooSGYlUJOYnl4Br5JgAX1XI9bARm5Q71h7sBcqVG')  -- ud8kakoo7quaetae0Afai2shaeph6u
ON CONFLICT DO NOTHING;