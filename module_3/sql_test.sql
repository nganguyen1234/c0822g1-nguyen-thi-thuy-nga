drop database tcomplex;
create database if not exists tcomplex;
use tcomplex;
create table trang_thai
(
    ma_trang_thai int auto_increment primary key,
    trang_thai    varchar(50)
);

create table loai_mat_bang
(
    ma_loai_mat_bang int auto_increment primary key,
    loai_mat_bang    varchar(50)
);

create table mat_bang
(
    ma_mat_bang      int auto_increment primary key,
    ma_trang_thai    int,
    dien_tich        double,
    tang             int,
    ma_loai_mat_bang int,
    mo_ta_chi_tiet   varchar(50),
    gia_cho_thue     double,
    ngay_bat_dau     varchar(50),
    ngay_ket_thuc    varchar(50),
    da_xoa           int default 0,
    foreign key (ma_trang_thai) references trang_thai (ma_trang_thai),
    foreign key (ma_loai_mat_bang) references loai_mat_bang (ma_loai_mat_bang)
);