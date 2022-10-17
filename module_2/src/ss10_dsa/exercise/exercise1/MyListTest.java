package ss10_dsa.exercise.exercise1;

import java.util.Arrays;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Nương bớt lố lăng đi");
        Student s2 = new Student(2, "Lan");
        Student s3 = new Student(3, "Diem");
        Student s4 = new Student(4, "Nga");
        Student s5 = new Student(5, "Linh");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(s1);
        studentMyList.add(s2);
        studentMyList.add(s3);
        studentMyList.add(s4);
        studentMyList.add(2, s5);
        studentMyList.remove(3);
        System.out.println("list size: " + studentMyList.size());
        for (int i = 0; i < studentMyList.size(); i++) {
            Student student = (Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
        System.out.println("Tên học sinh thứ 3: " + studentMyList.get(2).getName());
        System.out.println(studentMyList.indexOf(s1));
        System.out.println(studentMyList.contains(s3));
//        MyList<Student> newStudentList = new MyList<>();
//        newStudentList = studentMyList.clone();
    }
}
