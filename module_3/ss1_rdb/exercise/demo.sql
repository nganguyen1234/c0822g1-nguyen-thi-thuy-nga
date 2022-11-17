create database if not exists demo;
use demo;
create table student(
id int primary key,
`name` varchar(50),
score double
);
insert into student 
values(1,"ok",1.2),
(2,"nuong",1),
(3,"nga",0.5)
;
insert into student(id,score)
value(4,1);
select * from student;
select name,id from student;
update student set score=1 where id = 1;
update student set `name` = "nga" where id = 3;
set sql_safe_updates = 0;
delete from student where score = 0.5;
delete from student where id = 3;
set sql_safe_updates = 1;
