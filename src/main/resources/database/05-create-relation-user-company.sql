alter table company add client_id INT,
    add foreign key (client_id) REFERENCES client(id) ON UPDATE CASCADE