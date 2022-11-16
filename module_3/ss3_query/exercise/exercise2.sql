use store_management;
insert into customer(customer_name, customer_age) 
values 
  ('Minh Quan', 10), 
  ('Ngoc Oanh', 20), 
  ('Hong Ha', 50);
  
insert into `order`(
  customer_id, order_date, order_total_price
) 
values 
  (1, '2006-03-21', null), 
  (2, '2006-03-23', null), 
  (1, '2006-03-16', null);
  
insert into product(product_name, product_price) 
values 
  ('May Giat', 3), 
  ('Tu Lanh', 5), 
  ('Dieu Hoa', 7), 
  ('Quat', 1), 
  ('Bep Dien', 2);
  
insert into order_detail 
values 
  (1, 1, 3), 
  (1, 3, 7), 
  (1, 4, 2), 
  (2, 1, 1), 
  (3, 1, 8), 
  (2, 5, 4), 
  (2, 3, 3);
  
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select 
  order_id, 
  order_date, 
  order_total_price 
from 
  `order`;
  
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select 
  c.customer_name, 
  p.product_name 
from 
  order_detail as od 
  inner join `order` as o on o.order_id = od.order_id 
  inner join customer as c on c.customer_id = o.customer_id 
  inner join product as p on p.product_id = od.product_id;
  
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select 
  c.customer_name, 
  o.order_id 
from 
  customer as c 
  left join `order` as o on c.customer_id = o.customer_id 
where 
  o.order_id is null;
  
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select 
  o.order_id, 
  o.order_date, 
  sum(od.order_qty * p.product_price) as total_price 
from 
  order_detail as od 
  inner join `order` as o on o.order_id = od.order_id 
  inner join product as p on p.product_id = od.product_id 
group by 
  o.order_id;
