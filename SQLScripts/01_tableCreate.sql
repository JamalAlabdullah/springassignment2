DROP TABLE IF EXISTS superhero;

CREATE TABLE superhero(
	superhero_id serial PRIMARY KEY,
    superhero_name varchar(50),
    superhero_alias varchar(50),
    origin varchar(50));
	
DROP TABLE IF EXISTS assistant;

CREATE TABLE assistant(
	assistant_id serial PRIMARY KEY,
    assistant_name varchar(50));
	
DROP TABLE IF EXISTS hero_power;

CREATE TABLE hero_power(
	power_id serial PRIMARY KEY,
	power_name varchar(50),
	description varchar(50));

