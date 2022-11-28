create database furama_resort ;
create table `position`(id int auto_increment primary key,name varchar(50));
create table education_degree(id int auto_increment primary key , name varchar(50));
create table division(id int auto_increment primary key ,name varchar(50));
create table role(role_id int auto_increment primary key ,name varchar(50));
create table user(username varchar(255) primary key ,password varchar(255));
create table user_role(role_id int,username varchar(255),
foreign key (role_id) references role(role_id),
foreign key (username) references user(username));
create table employee(id int auto_increment primary key ,name varchar(50),date_of_birth date,id_card varchar(45),salary double,phone_number varchar(45),email varchar(45),address varchar(45),position_id int,education_degree_id int,division_id int,username varchar(255),
foreign key (position_id) references `position`(id),
foreign key (education_degree_id) references education_degree(id),
foreign key (division_id) references division(id),
foreign key (username) references user(username));

create table customer_type(id int auto_increment primary key,name varchar(50));
create table customer(id int auto_increment primary key ,customer_type_id int,name varchar(50),date_of_birth date,gender bit(1),id_card varchar(45),phone_number varchar(45),email varchar(45),address varchar(45),
foreign key (customer_type_id) references customer_type(id));

create table facility_type(id int auto_increment primary key ,name varchar(50));
create table rent_type(id int auto_increment primary key , name varchar(50));
create table facility(id int auto_increment primary key ,name varchar(50),area int,cost double,rent_type_id int,facility_type_id int,standard_room varchar(50),description_other_convenience varchar(50),pool_area double,number_of_floors int,facility_free text,
foreign key (rent_type_id) references rent_type(id),
foreign key (facility_type_id) references facility_type(id));

create table contract(id int auto_increment primary key ,start_date datetime, end_date datetime,deposit double,employee_id int,customer_id int,facility_id int,
foreign key (employee_id) references employee(id),
foreign key (customer_id) references customer(id),
foreign key (facility_id) references facility(id));
create table attach_facility(id int auto_increment primary key ,name varchar(50),cost double,unit varchar(50),status varchar(50));
create table contract_detail(id int auto_increment primary key ,contract_id int, attach_facility_id int,quantity int,
 foreign key (contract_id) references contract(id),
 foreign key (attach_facility_id) references attach_facility(id));