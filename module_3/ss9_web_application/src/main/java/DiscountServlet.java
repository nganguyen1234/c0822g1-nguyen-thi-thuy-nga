import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int price = Integer.parseInt(request.getParameter("price"));
double discountPercent = Integer.parseInt(request.getParameter("discount"));
double discountAmount = price * discountPercent * 0.01;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>discount amount:" +discountAmount+"</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
