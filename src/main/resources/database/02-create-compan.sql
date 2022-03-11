create table company(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) UNIQUE NOT NULL ,
    adress VARCHAR(255) NOT NULL ,
    nip VARCHAR(255) UNIQUE NOT NULL
)