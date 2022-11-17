use student_management;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from `subject` where credit = (select max(credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from `subject` 
where sub_id = (select sub_id from mark m where mark = (select max(mark) from mark));

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.*,avg(mark) as `avg`
from student as s
inner join mark as m on s.student_id = m.student_id
group by student_id
order by `avg` desc;