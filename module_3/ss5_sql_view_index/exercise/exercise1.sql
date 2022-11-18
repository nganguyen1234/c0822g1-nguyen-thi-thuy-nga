create database demo;
use demo;
create table products(
id int auto_increment primary key,
product_code int,
product_name varchar(50),
product_price double,
product_amount int,
product_description  varchar(50),
product_status varchar(50)
);

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values
(1,'May Giat', 3,1,'abc','abc'), 
  (2,'Tu Lanh', 5,23,'bcd','bcd'), 
  (3,'Dieu Hoa', 7,1,'cde','cde'), 
  (4,'Quat', 1,4,'def','def'), 
  (5,'Bep Dien', 2,3,'efg','efg');
  
 -- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
explain select * from products where product_code = 3;
create unique index i_code on products (product_code);
  
  -- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
explain select * from products where product_code = 3 and product_price = 7 ;
create index i_code_price on products(product_code,product_price);

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view w_product as 
select product_code,product_name,product_price,product_status from products;

select * from w_product;

-- Tiến hành sửa đổi view
update w_product set product_name = 'abcd' where product_code = 2;

-- Tiến hành xoá view
drop view w_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- delimiter //
-- create procedure sp_get_info()
-- begin
-- select * from products;
-- end // 
--  delimeter ;
--  
delimiter //
create procedure sp_products()
begin
select * from products;
end //
delimiter ;
call sp_products;
 
 