create database if not exists codegym_management;
use codegym_management;
create table instructor(
id int primary key,
`name` varchar(50),
birthday date,
salary double
);
create table class(
id int auto_increment primary key,
`name` varchar(50)
);

create table room(
id int auto_increment primary key,
class_id int,
foreign key(class_id) references class(id)
);
create table jame(
`account` varchar(50) primary key,
`password` varchar(50)
);

create table student(
id int auto_increment primary key,
`name` varchar(50),
gender int,
date_of_birth date,
email varchar(50),
`point` double,
`account` varchar(50),
foreign key(`account`) references jame(`account`),
class_id int,
foreign key(class_id) references class(id)
);

create table instructor_class(
instructor_id int,
class_id int,
primary key(instructor_id,class_id),
foreign key(instructor_id) references instructor(id),
foreign key(class_id) references class(id)
);
alter table instructor_class add start_time date;
insert into class values
(1,"c1121g1"),
(2,"c1221g1"),
(3,"a0821i1"),
(4,"a0921i1");
insert into jame values
("cunn","cunn"),
("chunglh","chunglh"),
("hoanhhh","hoanhhh"),
("dungd","dungd"),
("huynhtd","huynhtd"),
("hainm","hainm"),
("namtv","namtv"),
("hieuvm","hieuvm"),
("kynx","kynx"),
("vulm","vulm");
insert into student values
(1,"nguyen ngoc cu",1,'1981-12-12',null,8,"cunn",1),
(2,"le hai chung",1,'1981-12-12',null,5,"chunglh",1),
(3,"hoang huu hoan",1,'1990-12-12',null,6,"hoanhhh",2),
(4,"dau dung",1,'1987-12-12',null,8,"dungd",1),
(5,"ta dinh huynh",1,'1981-12-12',null,7,"huynhtd",2);
insert into student(`name`,gender,date_of_birth,email,`point`,`account`,class_id) values
("nguyen minh hai",1,'1987-12-12',null,9,"hainm",1),
("tran van nam",1,'1981-12-12',null,4,"namtv",2),
("vo minh hieu",1,'1981-12-12',null,3,"hieuvm",1),
("le xuan ky",1,'1981-12-12',null,7,"kynx",2),
("le minh vu",1,'1981-12-12',null,7,"vulm",1);
insert into student values
(15,"nguyen van a",1,'1981-12-12',null,8,null,null),
(16,"tran van b",1,'1981-12-12',null,5,null,null);

-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.
select * from student inner join class on student.class_id = class.id;
-- Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào và cả các bạn đã đăng ký nhưng chưa có lớp học.
select * from student left join class on student.class_id = class.id;
-- 4. Lấy thông tin của các học viên tên “Hai” và 'Huynh’.
select * from student where `name` like "% % %Hai%" or `name` like "% % %Huynh%";
-- 5. Lấy ra học viên có điểm lớn hơn 5 .
select * from student where `point`>5;
-- 6. Lấy ra học viên có họ là “nguyen”
select * from student where `name` like "%nguyen% % %";
-- 7. Thông kế số lượng học sinh theo từng loại điểm.
select `point`, count(`point`) from student group by `point`;
-- 8 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
select `point`, count(`point`) from student where `point`>5 group by `point`;
-- 9. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
select `point`, count(`point`) from student where `point`>5 group by `point` having count(`point`)>=2;
-- 10. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp tên học viên theo alphabet.
select * from student where class_id = 1 order by `name` asc;

-- các hàm thông dụng trong sql
insert into instructor values
(1,'tran van chanh','1985-03-02',100),
(2,'tran minh chien','1985-03-02',200),
(3,'vu thanh tien','1985-03-02',300),
(4,'tran van nam','1989-12-12',100);

insert into instructor_class values
(1,1,null),
(1,2,null),
(1,3,null),
(2,1,null),
(2,2,null),
(2,3,null);

-- 1.Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp
select c.*, count(s.id) as count
from class as c
inner join student as s on s.class_id = c.id
group by c.id;

-- 2. Tính điểm lớn nhất của mỗi các lớp
select c.*, max(s.point) as max_point
from class as c
inner join student as s on s.class_id = c.id
group by c.id;

-- 3.Tình điểm trung bình  của từng lớp
select c.*, avg(s.point) as avg_point
from class as c
inner join student as s on s.class_id = c.id
group by c.id;

-- 4.  Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym.
select i.`name`,i.birthday
from instructor as i
union
select s.`name`,s.date_of_birth
from student as s;

-- 5. Lấy ra top 3 học viên có điểm cao nhất của trung tâm.
select `name`,`point`
from student
order by `point` desc
limit 3;

-- 6. Lấy ra các học viên có điểm số là cao nhất của trung tâm.
select *
from student 
where `point` = (select max(point) from student);
