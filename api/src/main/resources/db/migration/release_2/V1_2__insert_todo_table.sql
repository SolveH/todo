CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
INSERT INTO todo ( id, name, complete)
VALUES
       (uuid_generate_v4(), 'Do your stuff', DEFAULT),
       (uuid_generate_v4(), 'Wash you', DEFAULT);