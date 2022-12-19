package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TamGiacVaDiem {
    public static void main(String[] args) {
        System.out.println(solve(0.2,1.1, 0.0, 0.3,2.0,0.0,4.0,0.0));
    }
    public static double solve(double Ax, double Ay, double Bx, double By, double Cx, double Cy, double Mx, double My) {
       double da = distance(Ax,Ay,Mx,My);
       double db = distance(Bx,By,Mx,My);
       double dc = distance(Cx,Cy,Mx,My);
       double r = Math.min(Math.min(da,db),dc);
        return r;
    }
    public static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return  Math.sqrt(dx * dx + dy * dy);
    }

}
