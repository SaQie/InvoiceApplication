
alter table invoice add seller_id INT,
    add foreign key (seller_id) references company(id);

alter table invoice add buyer_id INT,
    add foreign key (buyer_id) references company(id)