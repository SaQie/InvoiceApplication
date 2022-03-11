create table invoice(
    id SERIAL PRIMARY KEY ,
    number VARCHAR(255) UNIQUE NOT NULL ,
    created_date DATE NOT NULL ,
    payment_form VARCHAR(255) NOT NULL
)