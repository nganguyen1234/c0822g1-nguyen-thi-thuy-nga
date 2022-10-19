package ss4_class_object.exercise.excercise1;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * (this.a) * (this.c);
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        return (-this.b + Math.sqrt(delta)) / (2 * this.a);
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        return (-this.b - Math.sqrt(delta)) / (2 * this.a);
    }


}
