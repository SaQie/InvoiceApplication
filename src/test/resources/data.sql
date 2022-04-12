insert into client(id,username, email, password, role, created_date)
 values
        (1,'Kamil', 'test@o2.pl', '$2a$12$CNIgCxax8UrZyzGRd94XH.5XgD32miVQsrKBJDRE58I1At1Wc8Z3m', 'CLIENT', '2022-04-02'),
        (2,'Artur', 'artur@o2.pl', '$2a$12$CNIgCxax8UrZyzGRd94XH.5XgD32miVQsrKBJDRE58I1At1Wc8Z3m', 'CLIENT', '2022-04-02'),
        (3,'Pawel', 'pawel@o2.pl', '$2a$12$CNIgCxax8UrZyzGRd94XH.5XgD32miVQsrKBJDRE58I1At1Wc8Z3m', 'CLIENT', '2022-04-02'),
        (4,'Krzysztof', 'Krzysztof@o2.pl', '$2a$12$CNIgCxax8UrZyzGRd94XH.5XgD32miVQsrKBJDRE58I1At1Wc8Z3m', 'CLIENT', '2022-04-02'),
        (5,'Norbert', 'norbert@o2.pl', '$2a$12$CNIgCxax8UrZyzGRd94XH.5XgD32miVQsrKBJDRE58I1At1Wc8Z3m', 'CLIENT', '2022-04-02'),
        (6,'Michal', 'michal@o2.pl', '$2a$12$CNIgCxax8UrZyzGRd94XH.5XgD32miVQsrKBJDRE58I1At1Wc8Z3m', 'CLIENT', '2022-04-02');

insert into company(id, name, adress, nip, regon, phone_number, owner_name, owner_last_name, client_id)
values
        (1,'Mlekowita S.A', 'Komornika 2/2', '3411390381', '015730899', '123123123', 'Kamil', 'Nowak', 1),
        (2,'Kormoran S.A', 'Powstancow 2/4', '7991923659', '637800090', '123321321', 'Patryk', 'Kowalski', 2),
        (3,'Nintendo S.A', 'Lipowa 14', '9522511589', '034267432', '242424242', 'Michal', 'Bzik', 3),
        (4,'Oponeo S.A', 'Lipowa 12', '7975142571', '717483762', '999111234', 'Janina', 'Kowalska', 4);
