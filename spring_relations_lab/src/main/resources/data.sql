insert into role(name)
values ('ROOT'),
       ('ADMIN'),
       ('MANAGER'),
       ('EMPLOYEE');

insert into state(state_code, state_name)
values ('VA', 'Texas');

insert into users(firstname, lastname, password, email, role_id)
values ('ower', 'maiden', '12345', 'ower@cydeo.com',2);

insert into address(description, zip_code, state_id)
values ('This is an address', '12345', 1);

insert into category(category_name, tax)
values ('Electronics', 10);

insert into client(client_name, phone, email, address_id)
values ('OWER','12345555','orange@gmail.com', 1);

insert into product(name, price, category_id)
values ('Macbook', 120, 1);

insert into invoice(invoice_number, invoice_type, invoice_date, client_id)
values ('P-001', 'SALE', '2021-01-05 00:00:00', 1);

insert into invoice_product(quantity, profit, invoice_id, product_id)
values (10, 100, 1, 1);
