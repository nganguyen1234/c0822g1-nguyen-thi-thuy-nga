package ss10_dsa.exercise.exercise2;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

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
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student s1 = new Student(1, "Nga");
        Student s2 = new Student(1, "Nương");
        Student s3 = new Student(1, "Diễm");
        Student s4 = new Student(1, "Lan");
        Student s5 = new Student(1, "Linh");
        myLinkedList.addFirst(s1);
        myLinkedList.addFirst(s2);
        myLinkedList.addFirst(s3);
        myLinkedList.addLast(s4);
        myLinkedList.add(2,s5);
//        myLinkedList.remove(3);
        myLinkedList.remove(s2);
        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(((Student) myLinkedList.get(i)).getName());
        }
    }
}
