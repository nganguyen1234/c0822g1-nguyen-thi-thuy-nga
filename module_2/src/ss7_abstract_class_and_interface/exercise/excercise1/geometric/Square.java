package ss7_abstract_class_and_interface.exercise.excercise1.geometric;

public class Square extends Shape implements Resizeable,Colorable {
    private double side = 5;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
    @Override
    public String toString() {
        return "Square{" +
                "size=" + side +
                '}'+ ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.setSide(this.getSide()*(100+percent)/100);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides of the square.");
    }
}
