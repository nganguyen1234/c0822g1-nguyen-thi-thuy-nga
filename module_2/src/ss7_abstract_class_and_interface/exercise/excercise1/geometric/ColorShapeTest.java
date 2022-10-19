package ss7_abstract_class_and_interface.exercise.excercise1.geometric;

public class ColorShapeTest {
    public static void main(String[] args) {
        double percent = Math.random();
        percent = percent * 100 + 1;
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(6, 5);
        shapes[1] = new Square(6);
        shapes[2] = new Circle(1);
        System.out.println("Rectangle area = "+ ((Rectangle)shapes[0]).getArea());
        shapes[0].howToColor();
        System.out.println("Square area = "+ ((Square)shapes[1]).getArea());
        shapes[1].howToColor();
        System.out.println("Circle area = "+ ((Circle)shapes[2]).getArea());
        shapes[2].howToColor();

    }
}
