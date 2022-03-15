alter table company add user_id INT,
    add foreign key (user_id) REFERENCES users(id) ON UPDATE CASCADE