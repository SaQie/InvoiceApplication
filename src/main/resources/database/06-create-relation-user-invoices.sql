alter table invoice add user_id INT,
    add foreign key (user_id) references users(id)