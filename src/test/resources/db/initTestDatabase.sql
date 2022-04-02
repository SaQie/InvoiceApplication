create table client(
                       id SERIAL PRIMARY KEY ,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL ,
                       password VARCHAR(255) NOT NULL ,
                       role VARCHAR(255) NOT NULL ,
                       created_date DATE NOT NULL,
                       number_of_companies int NOT NULL
);

create table invoice(
                        id SERIAL PRIMARY KEY ,
                        number VARCHAR(255) UNIQUE NOT NULL ,
                        created_date DATE NOT NULL ,
                        payment_form VARCHAR(255) NOT NULL
);

create table company(
                        id SERIAL PRIMARY KEY ,
                        name VARCHAR(255) UNIQUE NOT NULL ,
                        adress VARCHAR(255) NOT NULL ,
                        nip VARCHAR(255) UNIQUE NOT NULL,
                        regon VARCHAR(255) UNIQUE NOT NULL ,
                        phone_number VARCHAR(255) UNIQUE NOT NULL,
                        owner_name VARCHAR(255) NOT NULL ,
                        owner_last_name VARCHAR(255) NOT NULL
);

create table product(
                        id SERIAL PRIMARY KEY ,
                        name VARCHAR(255) NOT NULL ,
                        description VARCHAR(255) NOT NULL ,
                        unit VARCHAR(255) NOT NULL ,
                        price NUMERIC NOT NULL ,
                        vat VARCHAR(255) NOT NULL
);

alter table company add client_id INT,
    add foreign key (client_id) REFERENCES client(id) ON UPDATE CASCADE;


alter table invoice add seller_id INT,
    add foreign key (seller_id) references company(id);

alter table invoice add buyer_id INT,
    add foreign key (buyer_id) references company(id);

alter table product add invoice_id INT,
    add foreign key (invoice_id) references invoice(id)