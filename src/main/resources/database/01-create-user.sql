create table users(
    id SERIAL PRIMARY KEY ,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL ,
    email VARCHAR(255) UNIQUE NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    created_date DATE NOT NULL
);
