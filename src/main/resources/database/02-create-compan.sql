create table company(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) UNIQUE NOT NULL ,
    adress VARCHAR(255) NOT NULL ,
    nip VARCHAR(255) UNIQUE NOT NULL,
    regon VARCHAR(255) UNIQUE NOT NULL ,
    phone_number VARCHAR(255) UNIQUE NOT NULL,
    owner_name VARCHAR(255) NOT NULL ,
    owner_last_name VARCHAR(255) NOT NULL
)