alter table users add company_id UNIQUE,
    add foreign key (company_id) REFERENCES company(id) ON UPDATE CASCADE