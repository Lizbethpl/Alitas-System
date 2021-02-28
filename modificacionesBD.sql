use db_Alitas;

select * from users;
select * from flavor;
select * from products;
select * from packages;
select * from sales_product;
select * from category;
select * from sales;
select * from additional;
select * from sales;



alter table packages add column id_package int auto_increment primary key;
alter table category drop foreign key fk_category_products1;
alter table category drop products_id_product;
insert into category(name_category) values ('ALITAS');
insert into category(name_category) values ('BONELESS');
insert into category(name_category) values ('HAMBURGUESAS');
insert into category(name_category) values ('PAPAS');
insert into category(name_category) values ('BEBIDAS');
insert into category(name_category) values ('POSTRES');

INSERT INTO `db_alitas`.`sales_product` (`name_sproduct`, `lot_sproduct`, `description_sproduct`, `total_sproduct`, `sales_id_sale`) VALUES ('jjjj', '7', 'jhbjh', '789', '1');
SHOW CREATE TABLE additional;
select * from additional;
alter table additional drop foreign key fk_additional_users1;
alter table additional drop users_id_user;
alter table additional add column price_additional double;
insert into additional(name_additional,price_additional) values ('GUACAMOLE',10);
insert into additional(name_additional,price_additional) values ('PEPINILLOS',10);
insert into additional(name_additional,price_additional) values ('CHAMPIÑONES',10);
insert into additional(name_additional,price_additional) values ('CHORIZO',10);
insert into additional(name_additional,price_additional) values ('QUESO MANCHEGO',10);
insert into additional(name_additional,price_additional) values ('SALCHICHA',10);
DELETE FROM sales_product WHERE name_sproduct="HAMBURGUESA HAWAIANA";

select name_sproduct, total_sproduct, id_sproduct from sales_product where sales_id_sale = 6;
SHOW CREATE TABLE sales;
select * from sales;
alter table sales drop foreign key fk_sales_users1;
alter table sales drop users_id_user;
alter table sales drop description_sale;
alter table sales add column client_sale varchar(80);
alter table sales add column id_sales_product int;

INSERT INTO sales (date_sale, total_sale,client_sale,id_sales_product) 
                VALUES ("2021/02/10",110,"Karina",7);
                
