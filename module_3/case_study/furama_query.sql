use furama;

-- 2.  Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 kí tự.
-- TH1: họ bắt đầu là H,K,T
select 
  *, 
  char_length(ho_ten) 
from 
  nhan_vien as nv 
where 
  ho_ten like 'H%' 
  or ho_ten like 'T%' 
  or ho_ten like 'K%' 
having 
  char_length(ho_ten) <= 15;
-- TH2: tên bắt đầu bằng H,T,K
select 
  *, 
  char_length(ho_ten) 
from 
  nhan_vien as nv 
where 
  substring_index(ho_ten, " ",-1) like 'H%' 
  or substring_index(ho_ten, " ",-1) like 'T%' 
  or substring_index(ho_ten, " ",-1) like 'K%' 
having 
  char_length(ho_ten) <= 15;
  
-- 3.  Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select 
  * 
from 
  khach_hang 
where 
  (
    dia_chi like "%Đà Nẵng%" 
    or dia_chi like '%Quảng Trị%'
  ) 
  and datediff(current_date, ngay_sinh)/ 365 between 18 
  and 50;
  
-- 4.  Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select 
  kh.*, 
  count(kh.ma_khach_hang) as so_lan_dat_phong 
from 
  khach_hang as kh 
  inner join loai_khach as lk on lk.ma_loai_khach = kh.ma_loai_khach 
  inner join hop_dong as hd on hd.ma_khach_hang = kh.ma_khach_hang 
where 
  ten_loai_khach = "Diamond" 
group by 
  kh.ma_khach_hang 
order by 
  so_lan_dat_phong;
  
-- 5. Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng.
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select 
  kh.ma_khach_hang, 
  kh.ho_ten, 
  lk.ten_loai_khach, 
  hd.ma_hop_dong, 
  dv.ten_dich_vu, 
  hd.ngay_lam_hop_dong, 
  hd.ngay_ket_thuc, 
  
  ifnull(dv.chi_phi_thue, 0)+ sum(
    ifnull(dvdk.gia * hdct.so_luong, 0)
  ) as tong_tien 
from 
  hop_dong as hd 
  right join khach_hang as kh on kh.ma_khach_hang = hd.ma_khach_hang 
  left join loai_khach as lk on lk.ma_loai_khach = kh.ma_loai_khach 
  left join hop_dong_chi_tiet as hdct on hdct.ma_hop_dong = hd.ma_hop_dong 
  left join dich_vu as dv on dv.ma_dich_vu = hd.ma_dich_vu 
  left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
group by 
  hd.ma_hop_dong;
  
-- 6.  Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của 
-- tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select 
  distinct dv.ma_dich_vu, 
  dv.ten_dich_vu, 
  dv.dien_tich, 
  dv.chi_phi_thue, 
  ldv.ten_loai_dich_vu 
from 
  dich_vu as dv 
  left join hop_dong as hd on hd.ma_dich_vu = dv.ma_dich_vu 
  left join loai_dich_vu as ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu 
where 
  dv.ma_dich_vu not in (
    select 
      distinct dv.ma_dich_vu 
    from 
      dich_vu as dv 
      left join hop_dong as hd on hd.ma_dich_vu = dv.ma_dich_vu 
    where 
      month(hd.ngay_lam_hop_dong) in (1, 2, 3) 
      and year(hd.ngay_lam_hop_dong) = 2021
  );
  
-- 7.  Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select 
  distinct dv.ma_dich_vu, 
  dv.ten_dich_vu, 
  dv.dien_tich, 
  dv.so_nguoi_toi_da, 
  dv.chi_phi_thue, 
  ten_loai_dich_vu 
from 
  dich_vu as dv 
  inner join loai_dich_vu as ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu 
  left join hop_dong as hd on hd.ma_dich_vu = dv.ma_dich_vu 
where 
  year(hd.ngay_lam_hop_dong) = 2020 
  and dv.ma_dich_vu not in (
    select 
      distinct dv.ma_dich_vu 
    from 
      dich_vu as dv 
      left join hop_dong as hd on hd.ma_dich_vu = dv.ma_dich_vu 
    where 
      year(hd.ngay_lam_hop_dong) = 2021
  );
  
-- 8.  Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- C1:
select 
  distinct ho_ten 
from 
  khach_hang;
-- C2:
select 
  ho_ten 
from 
  khach_hang 
group by 
  ho_ten;
-- C3:
select kh.ho_ten
from khach_hang as kh
union 
select kh.ho_ten
from khach_hang as kh;

-- 9.  Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select 
  *, 
  count( ma_khach_hang) 
from 
  hop_dong 
where 
  year(ngay_lam_hop_dong) = 2021 
group by 
  month(ngay_lam_hop_dong);
  
-- 10.  Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select 
  hd.ma_hop_dong, 
  hd.ngay_lam_hop_dong, 
  hd.ngay_ket_thuc, 
  hd.tien_dat_coc, 
  ifnull(
    sum(hdct.so_luong), 
    0
  ) as so_luong_dich_vu_di_kem 
from 
  hop_dong as hd 
  left join hop_dong_chi_tiet as hdct on hd.ma_hop_dong = hdct.ma_hop_dong 
group by 
  hd.ma_hop_dong;
  
-- 11.  Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng
-- bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select 
  kh.ma_khach_hang, 
  kh.ho_ten, 
  dvdk.ten_dich_vu_di_kem 
from 
  khach_hang as kh 
  inner join loai_khach as lk on lk.ma_loai_khach = kh.ma_loai_khach 
  inner join hop_dong as hd on hd.ma_khach_hang = kh.ma_khach_hang 
  left join hop_dong_chi_tiet as hdct on hdct.ma_hop_dong = hd.ma_hop_dong 
  left join dich_vu_di_kem as dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
where 
  lk.ten_loai_khach = "Diamond" 
  and (
    kh.dia_chi like "%Vinh%" 
    or "%Quảng Ngãi%"
  );
  
-- 12.  Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), 
-- so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select 
  hd.ma_hop_dong, 
  nv.ho_ten, 
  kh.ho_ten, 
  kh.so_dien_thoai, 
  dv.ma_dich_vu, 
  dv.ten_dich_vu, 
  ifnull(
    sum(hdct.so_luong), 
    0
  ) as so_luong_dich_vu_di_kem, 
  hd.tien_dat_coc 
from 
  hop_dong as hd 
  left join hop_dong_chi_tiet as hdct on hdct.ma_hop_dong = hd.ma_hop_dong 
  left join dich_vu as dv on hd.ma_dich_vu = dv.ma_dich_vu 
  left join khach_hang as kh on kh.ma_khach_hang = hd.ma_khach_hang 
  left join nhan_vien as nv on nv.ma_nhan_vien = hd.ma_nhan_vien 
where 
  month(hd.ngay_lam_hop_dong) in (10, 11, 12) 
  and year(hd.ngay_lam_hop_dong) = 2020 
  and hd.ma_dich_vu not in (
    select 
      distinct hd.ma_dich_vu 
    from 
      hop_dong as hd 
    where 
      (
        month(hd.ngay_lam_hop_dong) between 1 
        and 6
      ) 
      and year(hd.ngay_lam_hop_dong) = 2021
  ) 
group by 
  hd.ma_hop_dong;
  
-- 13.  Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create view w_dich_vu_chi_tiet_da_dat as 
select 
  dvdk.ma_dich_vu_di_kem, 
  sum(hdct.so_luong) as tong_so_luong 
from 
  hop_dong_chi_tiet as hdct 
  right join dich_vu_di_kem as dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
group by 
  dvdk.ma_dich_vu_di_kem;
select 
  * 
from 
  w_dich_vu_chi_tiet_da_dat;
select 
  dvdk.*, 
  wdv.tong_so_luong as so_luong_dich_vu_di_kem 
from 
  dich_vu_di_kem as dvdk 
  left join w_dich_vu_chi_tiet_da_dat as wdv on wdv.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem 
where 
  wdv.tong_so_luong = (
    select 
      max(tong_so_luong) 
    from 
      w_dich_vu_chi_tiet_da_dat as wdv
  ) 
group by 
  dvdk.ma_dich_vu_di_kem;

  
-- 14.  Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung
-- (được tính dựa trên việc count các ma_dich_vu_di_kem).
select 
  hd.ma_hop_dong, 
  ldv.ten_loai_dich_vu, 
  dvdk.ten_dich_vu_di_kem, 
  count(hdct.ma_dich_vu_di_kem) so_lan_su_dung 
from 
  hop_dong as hd 
  left join hop_dong_chi_tiet as hdct on hdct.ma_hop_dong = hd.ma_hop_dong 
  left join dich_vu_di_kem as dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
  left join dich_vu as dv on dv.ma_dich_vu = hd.ma_dich_vu 
  left join loai_dich_vu as ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu 
group by 
  hdct.ma_dich_vu_di_kem 
having 
  count(hdct.ma_dich_vu_di_kem) = 1;
  
-- 15.  Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai,dia_chi
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021
select 
  nv.*, 
  count(hd.ma_nhan_vien) 
from 
  nhan_vien as nv 
  left join hop_dong as hd on nv.ma_nhan_vien = hd.ma_nhan_vien 
where 
  year(hd.ngay_lam_hop_dong) in (2020, 2021) 
group by 
  nv.ma_nhan_vien 
having 
  count(hd.ma_nhan_vien) <= 3;
  
-- 16.  Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
SET 
  SQL_SAFE_UPDATES = 0;
delete from 
  nhan_vien nv 
where 
  not exists (
    select 
      * 
    from 
      hop_dong as hd 
    where 
      nv.ma_nhan_vien = hd.ma_nhan_vien 
      and year(hd.ngay_lam_hop_dong) in (2019, 2020, 2021)
  );
  
-- 17.  Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update 
  loai_khach as lk 
set 
  ten_loai_khach = 'Diamond' 
where 
  exists (
    select 
      * 
    from 
      hop_dong as hd 
      left join hop_dong_chi_tiet as hdct on hdct.ma_hop_dong = hd.ma_hop_dong 
      inner join khach_hang as kh on kh.ma_loai_khach = lk.ma_loai_khach 
      inner join dich_vu as dv on dv.ma_dich_vu = hd.ma_dich_vu 
      inner join dich_vu_di_kem as dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
    where 
      year(hd.ngay_lam_hop_dong)= 2021 
      and lk.ten_loai_khach = 'Platinium' 
    group by 
      hd.ma_khach_hang 
    having 
      sum(
        dv.chi_phi_thue + dvdk.gia * hdct.so_luong
      ) > 1000000
  );
  
-- 18.  Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
set 
  foreign_key_checks = 0;
delete from 
  khach_hang 
where 
  ma_khach_hang in (
    select 
      ma_khach_hang 
    from 
      hop_dong 
    where 
      year(ngay_lam_hop_dong)= 2020
  );
delete from 
  hop_dong_chi_tiet hdct 
where 
  exists (
    select 
      * 
    from 
      hop_dong as hd 
    where 
      hd.ma_hop_dong = hdct.ma_hop_dong 
      and year(hd.ngay_lam_hop_dong) != 2021
  );
delete from 
  hop_dong hd 
where 
  year(hd.ngay_lam_hop_dong) != 2021;
  
  -- 19.  Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update 
  dich_vu_di_kem as dvdk 
set 
  gia = gia * 2 
where 
  exists (
    select 
      * 
    from 
      hop_dong_chi_tiet as hdct 
      right join hop_dong as hd on hd.ma_hop_dong = hdct.ma_hop_dong 
    where 
      hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem 
      and year(hd.ngay_lam_hop_dong) = 2020 
    group by 
      hdct.ma_dich_vu_di_kem 
    having 
      sum(hdct.so_luong) > 10
  );
select 
  * 
from 
  hop_dong_chi_tiet as hdct 
  right join hop_dong as hd on hd.ma_hop_dong = hdct.ma_hop_dong 
  left join dich_vu_di_kem as dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
where 
  year(hd.ngay_lam_hop_dong) = 2020 
group by 
  hdct.ma_dich_vu_di_kem 
having 
  sum(hdct.so_luong) > 10;
  
-- 20.  Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị
-- bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select 
  ma_nhan_vien as id, 
  ho_ten, 
  email, 
  so_dien_thoai, 
  ngay_sinh, 
  dia_chi 
from 
  nhan_vien 
union all 
select 
  ma_khach_hang, 
  ho_ten, 
  email, 
  so_dien_thoai, 
  ngay_sinh, 
  dia_chi 
from 
  khach_hang;

-- 21.  Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu”
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
select * from nhan_vien;
select * from hop_dong;
insert into hop_dong values 
(13,'2020/12/12','2021/12/12',23,11,2,2),
(14,'2020/12/12','2021/10/12',0,12,2,4);

insert into nhan_vien values 
(11,'nuong','2004/11/11',111111,111111,11111,'nuongne@gmail.com','Hải Châu',1,2,2),
(12,'nga','2004/12/12',12121212,12121212,121212,'nga234@gmail.com','Hải Châu',3,2,3);
drop view v_nhan_vien;
create view v_nhan_vien as 
select 
  nv.* 
from 
  nhan_vien as nv 
  inner join hop_dong as hd on hd.ma_nhan_vien = nv.ma_nhan_vien 
where 
  nv.dia_chi like "%Hải Châu%" 
  and hd.ngay_lam_hop_dong = "2020/12/12";
  
-- 22.  Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu”
-- đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update 
  v_nhan_vien 
set 
  dia_chi = "Liên Chiểu";
  
-- 23.  Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó
-- với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
delimiter // create procedure sp_xoa_khach_hang (IN id int) begin 
set 
  foreign_key_checks = 0;
delete from 
  khach_hang 
where 
  ma_khach_hang = id;
end // delimiter;
call sp_xoa_khach_hang(2);

-- 24.  Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter // create procedure sp_them_moi_hop_dong (
  IN p_ma_hop_dong int, IN p_ngay_lam_hop_dong date, 
  IN p_ngay_ket_thuc date, IN p_tien_dat_coc double, 
  IN p_ma_nhan_vien int, IN p_ma_khach_hang int, 
  IN p_ma_dich_vu int
) begin if p_ma_hop_dong not in (
  select 
    ma_hop_dong 
  from 
    hop_dong
) 
and p_ma_nhan_vien in (
  select 
    ma_nhan_vien 
  from 
    nhan_vien
) 
and p_ma_khach_hang in (
  select 
    ma_khach_hang 
  from 
    khach_hang
) 
and p_ma_dich_vu in (
  select 
    ma_dich_vu 
  from 
    dich_vu
) then insert into hop_dong value (
  p_ma_hop_dong, p_ngay_lam_hop_dong, 
  p_ngay_ket_thuc, p_tien_dat_coc, 
  p_ma_nhan_vien, p_ma_khach_hang, 
  p_ma_dich_vu
);
end if;
end // delimiter;
call sp_them_moi_hop_dong(
  14, "2022-11-21", "2022-12-21", 340000, 
  3, 3, 3
);

-- 25.  Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong 
-- thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
create table lich_su(
  stt int auto_increment primary key, 
  tong_ban_ghi int
);
drop trigger tr_xoa_hop_dong;
delimiter // 
create trigger tr_xoa_hop_dong 
after 
  delete on hop_dong for each row begin insert into lich_su(tong_ban_ghi) 
	select count(*) from hop_dong;
end // 
delimiter //
-- SET SQL_SAFE_UPDATES = 0;
-- set 
--   foreign_key_checks = 0;
delete from hop_dong where ma_hop_dong = 4;

-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng,
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau:
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày.
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
create table lich_su_cap_nhat (
stt int auto_increment primary key,
trang_thai varchar(50),
thoi_gian datetime
);

delimiter //
create trigger tr_cap_nhat_hop_dong 
before update on hop_dong
for each row
begin
if (datediff(new.ngay_ket_thuc,old.ngay_lam_hop_dong)>=2) then
insert into lich_su_cap_nhat(trang_thai,thoi_gian)
values ("đã cập nhật thành công",now());
else
insert into lich_su_cap_nhat(trang_thai,thoi_gian)
values ("Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày",now());
end if;
end //
delimiter ;


