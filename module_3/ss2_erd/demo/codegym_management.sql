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

-- 1. L???y ra th??ng tin c??c h???c vi??n, v?? cho bi???t c??c h???c vi??n ??ang theo h???c l???p n??o.
select * from student inner join class on student.class_id = class.id;
-- L???y ra th??ng tin c??c h???c vi??n, v?? cho bi???t c??c h???c vi??n ??ang theo h???c l???p n??o v?? c??? c??c b???n ???? ????ng k?? nh??ng ch??a c?? l???p h???c.
select * from student left join class on student.class_id = class.id;
-- 4. L???y th??ng tin c???a c??c h???c vi??n t??n ???Hai??? v?? 'Huynh???.
select * from student where `name` like "% % %Hai%" or `name` like "% % %Huynh%";
-- 5. L???y ra h???c vi??n c?? ??i???m l???n h??n 5 .
select * from student where `point`>5;
-- 6. L???y ra h???c vi??n c?? h??? l?? ???nguyen???
select * from student where `name` like "%nguyen% % %";
-- 7. Th??ng k??? s??? l?????ng h???c sinh theo t???ng lo???i ??i???m.
select `point`, count(`point`) from student group by `point`;
-- 8 . Th??ng k??? s??? l?????ng h???c sinh theo ??i???m v?? ??i???m ph???i l???n h??n 5
select `point`, count(`point`) from student where `point`>5 group by `point`;
-- 9. Th??ng k??? s??? l?????ng h???c sinh theo ??i???m l???n h??n 5 v?? ch??? hi???n th??? v???i s??? l?????ng>=2
select `point`, count(`point`) from student where `point`>5 group by `point` having count(`point`)>=2;
-- 10. L???y ra danh s??ch h???c vi??n c???a l???p c1121g1 v?? s???p x???p t??n h???c vi??n theo alphabet.
select * from student where class_id = 1 order by `name` asc;

-- c??c h??m th??ng d???ng trong sql
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

-- 1.Hi???n th??? danh s??ch c??c l???p c?? h???c vi??n theo h???c v?? s??? l?????ng h???c vi??n c???a m???i l???p
select c.*, count(s.id) as count
from class as c
inner join student as s on s.class_id = c.id
group by c.id;

-- 2. T??nh ??i???m l???n nh???t c???a m???i c??c l???p
select c.*, max(s.point) as max_point
from class as c
inner join student as s on s.class_id = c.id
group by c.id;

-- 3.T??nh ??i???m trung b??nh  c???a t???ng l???p
select c.*, avg(s.point) as avg_point
from class as c
inner join student as s on s.class_id = c.id
group by c.id;

-- 4.  L???y ra to??n b??? t??n v?? ng??y sinh c??c instructor v?? student ??? CodeGym.
select i.`name`,i.birthday
from instructor as i
union
select s.`name`,s.date_of_birth
from student as s;

-- 5. L???y ra top 3 h???c vi??n c?? ??i???m cao nh???t c???a trung t??m.
select `name`,`point`
from student
order by `point` desc
limit 3;

-- 6. L???y ra c??c h???c vi??n c?? ??i???m s??? l?? cao nh???t c???a trung t??m.
select *
from student 
where `point` = (select max(point) from student);
