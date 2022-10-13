package ss7_abstract_class_and_interface.excercise.excercise1.geometric;

public class ResizeShapeTest {
    public static void main(String[] args) {
        double percent = Math.random();
        percent = percent * 100 + 1;
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(6, 5);
        System.out.println("Rectangle area before resize: " + ((Rectangle) shapes[0]).getArea());
        shapes[1] = new Square(6);
        System.out.println("Square area before resize: " + ((Square) shapes[1]).getArea());
        shapes[2] = new Circle(1);
        System.out.println("Circle area before resize: " + ((Circle) shapes[2]).getArea());
        shapes[0].resize(percent);
        System.out.println("Rectangle area after resize: " + ((Rectangle) shapes[0]).getArea());
        shapes[1].resize(percent);
        System.out.println("Square area before resize: " + ((Square) shapes[1]).getArea());
        shapes[2].resize(percent);
        System.out.println("Circle area before resize: " + ((Circle) shapes[2]).getArea());
    }
}
