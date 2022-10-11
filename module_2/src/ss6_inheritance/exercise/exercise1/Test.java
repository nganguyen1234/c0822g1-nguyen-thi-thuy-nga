package ss6_inheritance.exercise.exercise1;

public class Test {
static Circle circle1 = new Circle(2,"yellow");
  static   Cylinder cylinder1 = new Cylinder(3,"red",23);

    public static void main(String[] args) {
        System.out.println(circle1.toString()+ "\n"+ cylinder1.toString() );
    }
}
