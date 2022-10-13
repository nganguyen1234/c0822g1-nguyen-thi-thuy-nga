package ss6_inheritance.exercise.exercise1;

public class Test {

    public static void main(String[] args) {
        Circle circle1 = new Circle(2, "yellow");
        Cylinder cylinder1 = new Cylinder(3, "red", 23);
        System.out.println(circle1.toString() + "\n" + cylinder1.toString());
    }
}
