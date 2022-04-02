create table client(
    id SERIAL PRIMARY KEY ,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    role VARCHAR(255) NOT NULL ,
    created_date DATE NOT NULL,
    number_of_companies int NOT NULL
);
