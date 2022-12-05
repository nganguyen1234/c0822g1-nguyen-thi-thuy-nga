use user_repo;

delimiter //
create procedure display_user()
begin
select * from users;
end //
delimiter ;

delimiter //
create procedure edit_users(in p_id int,
in p_name varchar(50),
 in p_email varchar(50),
 in p_country varchar(50))
 begin
 update users set name = p_name where id = p_id;
 update users set email = p_email where id = p_id;
 update users set country = p_country where id = p_id;
end //
delimiter ;

delimiter //
create procedure delete_user(in p_id int)
begin
delete from users where id = p_id;
end //
delimiter ;

