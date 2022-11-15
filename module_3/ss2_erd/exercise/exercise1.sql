create database if not exists erd_demo;
use erd_demo;
create table phieu_xuat(
  so_px int auto_increment primary key, 
  ngay_xuat date
);
create table vat_tu(
  ma_vtu int auto_increment primary key, 
  ten_vtu varchar(50)
);
create table chi_tiet_phieu_xuat(
  so_px int, 
  ma_vtu int, 
  dg_xuat double, 
  sl_xuat int, 
  primary key(so_px, ma_vtu), 
  foreign key(so_px) references phieu_xuat(so_px), 
  foreign key(ma_vtu) references vat_tu(ma_vtu)
);
create table phieu_nhap(
  so_pn int auto_increment primary key, 
  ngay_nhap date
);
create table chi_tiet_phieu_nhap(
  ma_vtu int, 
  so_pn int, 
  dg_nhap double, 
  sl_nhap int, 
  primary key(ma_vtu, so_pn), 
  foreign key(so_pn) references phieu_nhap(so_pn), 
  foreign key(ma_vtu) references vat_tu(ma_vtu)
);
create table nha_cc(
  ma_ncc int auto_increment primary key, 
  ten_ncc varchar(50), 
  dia_chi varchar(50)
);
create table sdt(
  sdt int primary key, 
  ma_ncc int, 
  foreign key(ma_ncc) references nha_cc(ma_ncc)
);
create table don_dh(
  so_dh int auto_increment primary key, 
  ngay_dh date
);
create table cung_cap(
  ma_ncc int, 
  so_dh int, 
  primary key(ma_ncc, so_dh), 
  foreign key(ma_ncc) references nha_cc(ma_ncc), 
  foreign key(so_dh) references don_dh(so_dh)
);
create table chi_tiet_don_dh(
  ma_vtu int, 
  so_dh int, 
  primary key(ma_vtu, so_dh), 
  foreign key(ma_vtu) references vat_tu(ma_vtu), 
  foreign key(so_dh) references don_dh(so_dh)
);
