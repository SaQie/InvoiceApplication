create table product(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) NOT NULL ,
    description VARCHAR(255) NOT NULL ,
    unit VARCHAR(255) NOT NULL ,
    price NUMERIC NOT NULL ,
    vat VARCHAR(255) NOT NULL
)