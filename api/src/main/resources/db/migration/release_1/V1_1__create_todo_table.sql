CREATE TABLE  todo(
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    complete BOOL DEFAULT 'f' NOT NULL
);