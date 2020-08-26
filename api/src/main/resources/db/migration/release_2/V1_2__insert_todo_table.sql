CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
INSERT INTO todo ( id, name, complete)
VALUES
       (uuid_generate_v4(), 'Wash the dishes', DEFAULT),
       (uuid_generate_v4(), 'Feed your squirrel', DEFAULT),
       (uuid_generate_v4(), 'Drink Coca-Cola', DEFAULT),
       (uuid_generate_v4(), 'Work out', DEFAULT),
       (uuid_generate_v4(), 'Pet the dog', DEFAULT);