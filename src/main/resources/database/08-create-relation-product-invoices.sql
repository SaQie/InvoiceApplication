alter table product add invoice_id INT,
    add foreign key (invoice_id) references invoice(id)